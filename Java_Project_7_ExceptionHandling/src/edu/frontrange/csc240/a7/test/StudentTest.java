
package edu.frontrange.csc240.a7.test;

import edu.frontrange.csc240.a7.Date;
import edu.frontrange.csc240.a7.Degree;
import edu.frontrange.csc240.a7.Student;
import edu.frontrange.csc240.a7.StudentException;
import edu.frontrange.util.ObjectCounter;

import static java.lang.System.out;

/**
 * A test program for ensuring that the Student class is functional. This is a
 * very brief test, and does not test in depth.
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
@SuppressWarnings( { "BroadCatchBlock", "TooBroadCatch",
							"CallToThreadDumpStack", "CallToPrintStackTrace" } )
public void run()
{
	System.setErr(out);

	out.println("** Testing Student Class");
	out.println();
	out.println("** Test Student Values:");
	out.println();

	/* Set up a date to use for this student. */
	Date testDate = new Date(12, 10, 1982);

	Throwable throwable = null;
	Student testStudent1 = null;
	Student testStudent2 = null;
	try
	{
		/* Create a student, and print the details. */
		testStudent1 = new Student("S00001234", "Mdffthp", "Fjspw",
				testDate, Degree.AASCIS);
		out.println(testStudent1.getDetails());
		out.println();

		/* Create a second student, and print the details. */
		testStudent2 = new Student("S00004321", "Mkdwqk", "Fjspw");
		out.println(testStudent2.getDetails());
		out.println();
	} catch( StudentException studentException )
	{
		out.println("**?? Error in constructing a Student.");
		throwable = studentException;
	} catch( Throwable unexpected )
	{
		out.println("**?? Unexpected exception thrown during construction.");
		throwable = unexpected;
	} finally
	{
		Throwable t = throwable;
		while( t != null )
		{
			out.println("**?? " + t.getMessage());
			t = t.getCause();
		}
		if( throwable != null ) throwable.printStackTrace();
	}

	Student testStudent3;
	try
	{
		/* Create a student that is incorrect (the student number is short, and
		   will cause a failure. */
		out.println("** The next student is expected to cause a failure.");
		testStudent3 = new Student("S0000678", "Jimmy", "Flint");
		out.println("** " + testStudent3.getDetails());
		out.println();
	} catch( StudentException studentException )
	{
		out.println("**Expected exception caught: the message is:");
		out.println("**" + studentException.getMessage());
		out.println("**Cause of the exception is:");
		Throwable cause = studentException.getCause();
		out.println(cause == null ? "<No cause given>" :
				cause.getClass().getName() + "/\"" + cause.getMessage() + "\"");
		throwable = null;
	} catch( Throwable unexpected )
	{
		out.println("**?? Unexpected exception thrown during construction.");
		throwable = unexpected;
	} finally
	{
		Throwable t = throwable;
		while( t != null )
		{
			out.println("**?? " + t.getMessage());
			t = t.getCause();
		}
		if( throwable != null ) throwable.printStackTrace();
	}
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
 * Execute:
 * <pre>java edu.frontrange.csc240.a7.StudentTest</pre>
 *
 * @param args	unused.
 */
public static void main(String... args)
{
	new StudentTest().run();
}
}
