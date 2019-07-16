
package edu.frontrange.csc240.a7;

/**
 * This class handles exceptions thrown from the Course class and passes those
 * exceptions to the base class. 
 * @author William Archbold, S02369823
 * @version 2018-10-16, CSC-240 Assignment 7 CourseException.java
 */
public class CourseException extends Exception {
  
    public CourseException(String message) {
	super(message);
    }
    public CourseException(String message, Throwable object) {
	super(message, object);
    }
}

