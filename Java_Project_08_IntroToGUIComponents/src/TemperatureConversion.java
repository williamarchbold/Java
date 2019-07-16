
import javafx.application.Application;

/**
 * Main application. This launches the View (which in turn starts the corresponding
 * Controller, and which in a further turn sets up the needed Model) for the BMI
 * calculator application. Further details on this design paradigm may be found on
 * at <a href=http://en.wikipedia.org/wiki/Model%E2%80%93View%E2%80%93Controller>
 * http://en.wikipedia.org/wiki/Model-View-Controller</a>.
 *
 * @author	William Archbold, S02369823
 * @version	2018-10-29, CSC-240 Assignment 8, TemperatureConversion.java
 */
public class TemperatureConversion {
/**
 * Private constructor to prevent instantiation other than here in the main method. 
 * Prevents Java from creating a constructor with public variables. 
 */
private TemperatureConversion() {}

/**
 * Main entry point. Static because it doesn't require an instance of the class
 * TemperatureConversion. 
 * <p>
 * Execute: </p>
 * <pre>java edu.frontrange.csc240.example7.BMICalculator</pre>
 *
 * @param args	Not used.
 */
public static void main(String[] args)
{
	/* Create an instance of the view class, and start it running, using the
	   Application launch method. */
	Application.launch(View.class, args);
}
}
