
package edu.frontrange.csc240.a6.test;

import edu.frontrange.csc240.a6.Date;
import edu.frontrange.csc240.a6.Degree;
import edu.frontrange.csc240.a6.Student;
import edu.frontrange.util.ObjectCounter;

import static java.lang.System.out;

/**
 * A test program for ensuring that the Student class is functional.
 * This is a very brief test, and does not test in depth.
 *
 * @author		Dr. Bruce K. Haddon, Instructor
 * @version		3.0, 2018-03-06, CSC-240 Assignment 6, per the Assignment
 *				Instructions
 */
public class StudentTest
{
/**
 * Run the actual tests.
 */
public void run()
{
	System.setErr(out);

	out.println("Testing Student Class");
	out.println();
	out.println("Test Student Values:");
	out.println();

	/* Set up a date to use for this student. */
	Date testDate = new Date(12, 10, 1982);

	/* Create a student, and print the details.  */
	Student testStudent1 = new Student("S00001234", "Mdffthp", "Fjspw",
			testDate, Degree.AASCIS);
	out.println(testStudent1.getDetails());
	out.println();

	/* Create a second student, and print the details.  */
	Student testStudent2 = new Student("S00004321", "Mkdwqk", "Fjspw");
	out.println(testStudent2.getDetails());
	out.println();

	/* Count the number of student instances that exist. */
	out.println("Count of Student objects = " +
								ObjectCounter.getCounter(Student.class));

	if( testStudent1 == null || testStudent2 == null )
		throw new AssertionError("Error in testing.");
}

/**
 * Program entry point.
 *
 * <p>
 * Execute:</p>
 * <pre>java edu.frontrange.csc240.a6.StudentTest</pre>
 *
 * @param args		unused.
 */
public static void main(String... args)
{
	new StudentTest().run();
}
}

