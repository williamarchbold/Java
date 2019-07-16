
package edu.frontrange.csc240.a7;

import edu.frontrange.util.ObjectCounter;

/**
 * A Course is an offering in the College system. A number of Sections may be
 * associated with each course. A Course has a standard prefix (to indicate the
 * department, a number within that department, and a name. Each course is worth
 * a given number of credit hours per semester.
 *
 * @author William Archbold, S02369823
 * @version 2018-10-16, CSC-240 Assignment 7 Course.java
 */
public class Course
{
/**
 * Valid length for a courseNum string.
 */
private static final int COURSE_NUMBER_LENGTH = 3;

/**
 * Default course number value.
 */
private static final String DEFAULT_COURSE_NUMBER = "";

/**
 * Default course name value.
 */
private static final String DEFAULT_COURSE_NAME = "";

/**
 * Default credits value.
 * <p>
 * (Public so that this value will be part of the API.)
 */
public static final int DEFAULT_CREDITS_VALUE = 0;

/**
 * Maximum permitted credits for a course.
 * <p>
 * (Public so that this value will be part of the API.)
 */
public static final int MAXIMUM_CREDITS = 5;

/**
 * Minimum permitted credits for a course.
 * <p>
 * (Public so that this value will be part of the API.)
 */
public static final int MINIMUM_CREDITS = DEFAULT_CREDITS_VALUE;

/**
 * Required object counter field.
 */
private final ObjectCounter counter = new ObjectCounter(getClass());

/**
 * The name given to the course.
 */
private String courseName;

/**
 * The three-character &ldquo;course number&rdquo;.
 */
private String courseNum;

/**
 * The prefix (i.e., department) for the course.
 */
private final Prefix coursePrefix;

/**
 * The number of credits allocated to this course.
 */
private int credits;

/**
 * Set the course prefix (i.e., the department in which the course is being
 * taught), the number of the course within the department, and the name of the
 * course. Set the number of credits by default to zero to indicate that the
 * number of credits has not been set.
 *
 * @param coursePrefix	the designated department prefix
 * @param courseNum		the three-character course number within the department
 * @param courseName	the name of the course
 */
public Course(Prefix coursePrefix, String courseNum, String courseName)
        throws CourseException
{
	this(coursePrefix, courseNum, courseName, DEFAULT_CREDITS_VALUE);
}

/**
 * Set the course prefix (i.e., the department in which the course is being
 * taught), the number of the course within the department, and the name of the
 * course. Set the number of credits to the given value..
 *
 * @param coursePrefix	the three-letter department prefix (represented by a
 *						member of the Prefix enumeration
 * @param courseNum		the three-character course &ldquo;number&rdquo; within
 *						the department (replaced by null if not three characters)
 * @param courseName	the name of the course (replaced by null if the string is
 *						empty
 * @param credits		the number of semester credits for the course, 0 to 5; if
 *						outside this range, the number of credits is replaced by
 *						zero
 */
public Course(Prefix coursePrefix, String courseNum, String courseName, int credits)
        throws CourseException
{
	this.coursePrefix = coursePrefix;

	/* If the course number is valid, set courseNum to it. */
	this.courseNum = DEFAULT_COURSE_NUMBER;
	try {
            if( isValidCourseNum(courseNum) )
		this.courseNum = courseNum;

            /* If the course name is valid, set courseName to it. */
            this.courseName = DEFAULT_COURSE_NAME;
            if( isValidCourseName(courseName) )
                    this.courseName = courseName;

            /* If the number of credits is valid, set credits to it. */
            this.credits = DEFAULT_CREDITS_VALUE;
            if( isValidCredits(credits) )
                    this.credits = credits;
        }
        catch (ValidationException ex) {
            throw new CourseException("Course credits is invalid", ex);
        }
}

/**
 * The number of credits for the course.
 *
 * @return	the number of credits for the course (0 if no credits or will be set
 *          later, or the default if an	incorrect number of credits has been
 *			indicated)
 */
public int getCredits()
{
	return this.credits;
}

/**
 * Set the number of credits for the course.
 *
 * @param credits	the number of credits for the course. If the number is outside
 *					the permitted range, the course credit is set to the default.
 */
public void setCredits(int credits) throws ValidationException
{
	this.credits = DEFAULT_CREDITS_VALUE;
	if ( isValidCredits(credits) )
		this.credits = credits;
        else {
            throw new ValidationException("Course credits is invalid.");
        }
}

/**
 * Create a String detailing the name of the course, and the number of credits.
 *
 * @return			the name of the course, and the number of credits
 */
public String getDetails()
{
	return String.join(" ",
			toString(), courseName, String.valueOf(credits), "Credits");
}

/**
 * Course number (prefixed)
 *
 * @return			Course number (prefixed)
 */
@Override
public String toString()
{
	return coursePrefix.name() + "-" + courseNum;
}

/**
 * Validate the courseName string. It must not be empty.
 *
 * @param courseName	the courseName string
 * @return				true if the string if valid, otherwise false
 */
private static boolean isValidCourseName(String courseName)
        throws ValidationException
{
	if (courseName != null && !courseName.isEmpty()) {
            return true;
        }
        throw new ValidationException("Course name invalid.");
}

/**
 * Validate the courseNum string. It must be exactly three characters.
 *
 * @param courseNum		the courseNum string
 * @return				true if the string if valid, otherwise false
 */
private static boolean isValidCourseNum(String courseNum)
        throws ValidationException
{
	if (courseNum != null && courseNum.length() == COURSE_NUMBER_LENGTH) {
            return true;
        }
        throw new ValidationException("Course number invalid.");
}

/**
 * Validate the value of the course credits. The value must be in the range
 * MINIMUM_CREDITS&nbsp;&ndash;&nbsp;MAXIMUM_CREDITS.
 *
 * @param credits		the credits value
 * @return				true if the value if valid, otherwise false
 */
private static boolean isValidCredits(int credits)
        throws ValidationException
{
	if (credits >= MINIMUM_CREDITS && credits <= MAXIMUM_CREDITS) {
            return true;
        }
        throw new ValidationException("Course credits invalid.");
}
}
