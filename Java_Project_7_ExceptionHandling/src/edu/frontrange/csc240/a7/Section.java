
package edu.frontrange.csc240.a7;

import edu.frontrange.util.ObjectCounter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * A section is a sub-division of a course. A course may have multiple sections
 * when there are too many students in the course for them all to attend at the
 * same place at the same time with the same Instructor.
 *
 * @author William Archbold, S02369823
 * @version 2018-10-16, CSC-240 Assignment 7 Section.java
 */
public class Section
{
/**
 * Default section number.
 */
private static final String DEFAULT_SECTION_NUMBER = "";

/**
 * Constant for building Strings with newline characters within them.
 */
private static final String LINE_SEPARATOR = System.getProperty("line.separator");

/**
 * The maximum number of students permitted into a section.
 */
private static final int MAXIMUM_STUDENTS_PER_SECTION = 30;

/**
 * Valid length for a sectionNumber string.
 */
private static final int SECTION_NUMBER_LENGTH = 3;

/**
 * Required object counter field.
 */
private final ObjectCounter counter = new ObjectCounter(getClass());

/**
 * The date at which the section is finished.
 */
private Date endDate;

/**
 * The end time for the meeting of the section.
 */
private Time2 endTime;

/**
 * The list of students in the class. This declaration uses the Java 7 facility
 * of not repeating the generic type if that type can be inferred by the
 * compiler.
 */
private final List<Student> roster = new ArrayList<>();

/**
 * The three-character designation of the section (called a
 * &ldquo;section number&rdquo;).
 */
private String sectionNumber;

/**
 * The date on which the section starts to meet.
 */
private Date startDate;

/**
 * The time of day at which the section meets.
 */
private Time2 startTime;

/**
 * The course of which this is a section.
 */
private final Course thisCourse;

/**
 * Constructor.
 *
 * @param course		the course of which this is a section
 * @param sectionNumber	the section number (within the course) of this section
 */
public Section(Course course, String sectionNumber) throws SectionException
{
	/* No checking needed as a course is defined by another class. */
	this.thisCourse = course;

	this.sectionNumber = DEFAULT_SECTION_NUMBER;
	try {
            if( isValidSectionNumber(sectionNumber))
		this.sectionNumber = sectionNumber;
        }
        catch (ValidationException ex) {
            throw new SectionException("Section number is invalid.", ex);
        }
}

/**
 * Add a student to the course.
 *
 * @param student	the student object to be added. If the course is full, the
 *					student is not added
 */
public void addStudent(Student student) throws IllegalStateException
{
	if (student == null) {
            throw new IllegalArgumentException("Student was null");
        }
        if( roster.size() != MAXIMUM_STUDENTS_PER_SECTION )
		roster.add(student);
        else {
            throw new IllegalStateException("Student capacity is full.");
        }
}

/**
 * Get details about the current state of this section, including the course of
 * which it is part, the dates it starts and ends, times, etc., and the current
 * count of the enrollment.
 *
 * @return	the section details
 */
public String getDetails()
{
	return String.join(LINE_SEPARATOR,
			"Section: " + this.toString(),
			"Course: " + thisCourse.getDetails(),
			"Dates: " + startDate + " to " + endDate,
			"Times: " + startTime + " to " + endTime,
			"Enrollment: " + roster.size());
}

/**
 * Create a string that represents the information about the students in the
 * course.
 *
 * @return		a string that represents the information about the students in the
 *				course
 */
public String getRoster()
{
	/* The following commented-out code is the obvious way to do this, using
	   String concatenation (and this is acceptable). However, the recommended
	   Java approach to this kind of operation is to use a StringJoiner (new
	   class in Java 8), as this uses less garbage collection resources. */
//	String result = "";
//	for( Student student : roster )
//	{
//		result += ( result.isEmpty() ? "" : LINE_SEPARATOR) + student;
//	}
//	return result;

	StringJoiner stringJoiner = new StringJoiner(LINE_SEPARATOR);
	for( Student student : roster )
		stringJoiner.add(student.toString());
	return stringJoiner.toString();
}

/**
 * Get a count of the number of students registered (on the roster) for this course.
 *
 * @return	a count of the number of students registered for this course
 */
public int getRosterCount()
{
	return roster.size();
}

/**
 * Get the section number for this course.
 *
 * @return	the section number for this course
 */
public String getSectionNumber()
{
	return sectionNumber;
}

/**
 * Set the start and end dates for the section.
 *
 * @param startDate		the start date
 * @param endDate		the end date
 */
public void setDates(Date startDate, Date endDate)
{
	assert (startDate != null): "startDate is invalid.";
        assert (endDate != null): "endDate is invalid"; 
	this.startDate = startDate;
	this.endDate = endDate;
}

/**
 * Set the start time and the end time for the meetings of the section.
 *
 * @param startTime		the start time for meetings of the section
 * @param endTime		the end time for the meetings of the section
 */
public void setTimes(Time2 startTime, Time2 endTime)
{
	assert(startTime != null): "startTime is invalid.";
        assert(endTime != null): "endTime is invalid.";
	this.startTime = startTime;
	this.endTime = endTime;
}

/**
 * Section number (prefixed)
 *
 * @return	Section number (prefixed)
 */
@Override
public String toString()
{
	return thisCourse.toString() + "-" + sectionNumber;
}

/**
 * Validate the sectionNumber string. It must be of the correct length.
 *
 * @param sectionNumber	the sectionNumber string
 * @return				true if the string if valid, otherwise false
 */
private static boolean isValidSectionNumber(String sectionNumber) 
        throws ValidationException
{
	if (sectionNumber != null &&
			sectionNumber.length() == SECTION_NUMBER_LENGTH)
            return true;
        throw new ValidationException("Section number invalid.");
    }

}
