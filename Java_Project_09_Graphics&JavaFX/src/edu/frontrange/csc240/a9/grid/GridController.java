
package edu.frontrange.csc240.a9.grid;

import edu.frontrange.util.javafx.message.MessageDisplay;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

/**
 * Controller for the exercise of displaying a tic-tac-toe board on the screen.
 *
 * @author	Dr. Bruce K. Haddon, Instructor
 * @version	3.0, 2018-11-05, CSC-240 Assignment 9
 */
public class GridController implements Initializable
{
/**
 * (GUI) The panel holding and showing the actual board.
 */
private Canvas canvas;

/**
 * Overall size of the canvas.
 */
private double canvasSize;

/**
 * The model for this controller.
 */
private final GridModel model;

/**
 * (GUI) Title
 */
private String title;

/**
 * The view for which this is the controller
 */
private final GridView view;

/**
 * Parameter values from the command line (if any).
 */
private final List<String> values;

/**
 * Constructor.
 *
 * @param view			    the view for which this is the controller
 * @param parameters	list obtained as command line parameters
 */
public GridController(GridView view, List<String> parameters)
{
	/* Copy the parameter list, because it is unmodifiable. */
	this.values = new LinkedList<>();
	values.addAll(parameters);

	/* The view for which this is the controller. */
	this.view = view;

	/* Get the model being used by this controller. */
	model = new GridModel();

	/* Make the view an observer of the view. */
	model.addObserver(view);
}

/**
 * Get the panel on which the tic tac toe board is to be drawn.
 *
 * @return the boardPanel
 */
public Canvas getCanvas()
{
	return canvas;
}

/**
 * Inform the caller of the model used by this controller.
 *
 * @return	the model
 */
public GridModel getModel()
{
	return model;
}

/**
 * @return the title
 */
public String getTitle()
{
	return title;
}

/**
 * Create the components for the controls needed in the view. Validate the given
 * cell count and cell size.
 *
 * @param url	not used
 * @param rb		not used
 */
@Override
public void initialize(URL url, ResourceBundle rb)
{
	/* Deal witht the values input by the user. */
	processInputs();

	/* This listener listens to the scene in which the canvas is embedded, when
	   the size of the scene is change, the canvas is redrawn (and also resize). */
	@SuppressWarnings("Convert2Lambda")
	InvalidationListener listener = new InvalidationListener()
	{
	@Override
	public void invalidated(Observable o)
	{
		double width = view.getScene().getWidth();
		double height = view.getScene().getHeight();
		if( width == 0.0 || Double.isNaN(width) ) return;
		if( height == 0.0 || Double.isNaN(height) ) return;
		model.draw(canvas, width, height);
	}
	};

	/* Add this listener to the width and height properties of the scene. */
	view.getScene().widthProperty().addListener(listener);
	view.getScene().heightProperty().addListener(listener);

	/* Set the intial size to hold the count of cells with the given spacing. If 
	   the window is resized, the count of squares is kept the same, but the cell 
	   size is changed to accomodate the window size. */
	canvasSize = model.getCanvasSize();
	canvas = new Canvas(canvasSize, canvasSize);
	model.draw(canvas, canvasSize, canvasSize);

	/* The title for the application. */
	title = "Grid";
}

/**
 * Process the values specified by the user, either via the commandline or
 * by responding to pop-ups requesting values.
 */
private void processInputs()
{
	StringJoiner messages = new StringJoiner(System.lineSeparator());
	messages.setEmptyValue("");
	if( values.size() < 1 )					// value 1 here is 1
	{
		String result = MessageDisplay.inputMessage("Cell Count",
				"Enter a count of cells");
		if( result == null ) System.exit(0);
		values.add(result);
	}

	int cellCount = 0;
	String countString = values.get(0).replaceAll("\\s|_|,", "");
	try
	{
		cellCount = Integer.valueOf(countString);
	} catch( NumberFormatException ex )
	{
	}
	/* Set and check the cell count. */
	if( !model.setCellCount(cellCount) )
		messages.add("Cell count \"" + countString + "\" is invalid; " +
				"replaced by " + model.getCellCount());

	/* Check the given cell size. */
	if( values.size() < 2 )				// value 2 here is 2
	{
		String result = MessageDisplay.inputMessage("Cell Size",
				"Enter size of cells (pixels)");
		if( result == null ) System.exit(0);
		values.add(result);
	}
	double cellSize = 0;
	String sizeString = values.get(1).replaceAll("\\s|_|,", "");
	try
	{
		cellSize = Double.valueOf(sizeString);
	} catch( NumberFormatException ex )
	{
	}
	/* Set and check the cell count. */
	if( !model.setCellSize(cellSize) )
		messages.add("Cell size \"" + sizeString + "\" is invalid; " +
				"replaced by " + model.getCellSize());

	/* If there are any messages, pass them to the View for later display. */
	if( messages.length() != 0 ) view.setMessage(messages.toString());
}
}
