
package edu.frontrange.csc240.a6;

import edu.frontrange.util.ObjectCounter;

/**
 * The Course class allows the user to create a Course object and set the 
 * corresponding course number and number of credits
 * @author William Archbold, S02369823
 * @version 2018-10-09, CSC-240 Assignment 6 Course.java
 */
public class Course {
    
    //Create a reference variable counter to a new ObjectCounter object. The
    //ObjectCounter.java file increments the counter for every new object created
    private final ObjectCounter counter = new ObjectCounter(getClass());
    
    private String courseName;
    private String courseNum;
    private int credits;
    private Prefix coursePrefix;
    private static final int COURSE_NUM_LENGTH = 3;
    
    /**
     * Overloaded constructor for a Course object using 3 parameters. 
     * @param coursePrefix Type Prefix created in Prefix.java file
     * @param courseNum String type that will represent the course number
     * @param courseName String type that will represent the course name
     */
    public Course(Prefix coursePrefix, String courseNum, String courseName) {
        //this(coursePrefix, courseNum, courseName, 0);
        
        this.coursePrefix = coursePrefix;
        
        /*check if null to initiate short circuit or else error will occur 
        because can't find length of null
        */
        if (courseNum == null || courseNum.length() != COURSE_NUM_LENGTH) { 
            courseNum = ""; //conditionally corrects local variable
        }
        this.courseNum = courseNum;
        
        /*check if null first to initiate short circuit or else error will occur 
        becasue can't find length of null
        */
        if (courseName == null || courseName.length() == 0) {   // if (String.isEmpty(courseName))...
            courseName = ""; //conditionally corrects local variable
        }
        this.courseName = courseName;
    }
    
    /**
     * Overloaded constructor with 4 parameters. This constructor will call the
     * constructor with 3 parameters to prevent redundant code 
     * @param coursePrefix
     * @param courseNum
     * @param courseName
     * @param credits 
     */
    public Course(Prefix coursePrefix, String courseNum, String courseName, int credits) {
        
        this(coursePrefix, courseNum, courseName);
        //this.credits = credits;
        setCredits(credits);
    }
    
    /**
     * Method getCredits. Credits is private but public method allows user to access
     * private variable
     * @return credits of int type
     */
    public int getCredits() {
        return this.credits;
    }
    
    /**
     * Method setCredits to change the number of credits in credits variable. 
     * @param numCredits 
     */
    public void setCredits(int numCredits) {
        //if (this.credits != 0) {
        //    throw new 
        //}
        if (numCredits < 1 || numCredits > 5) {
            numCredits = 0;
        }
        this.credits = numCredits; 
    }
    
    /**
     * Method getDetails to see the details of a particular course object.
     * @return a formatted string concatenating all the details 
     */
    public String getDetails() {
        return String.format("%s-%s %s %d Credits", this.coursePrefix, this.courseNum, 
                this.courseName, this.credits);
    }
    
    @Override //sub class inheritence from java.lang.object so need overriding 
    public String toString() {
        return String.format("%s-%s", this.coursePrefix, this.courseNum);
    }
    
    
    
    
}
