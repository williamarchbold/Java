
package edu.frontrange.csc240.a9.grid;

import edu.frontrange.util.javafx.message.MessageDisplay;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.scene.control.Alert.AlertType.INFORMATION;

/**
 * A Window for displaying a grid, with a label for the window.
 *
 * @author	Dr. Bruce K. Haddon, Instructor
 * @version	3.0, 2018-11-05, CSC-240 Assignment 9
 */
public class GridView extends Application implements Observer
{
/**
 * The controller for this view.
 */
private GridController controller;

/**
 * Any messages to be displayed when the window starts.
 */
private String message;

/**
 * The scene that is the content of the window.
 */
private Scene scene;

/**
 * Constructor: a window to hold a grid.
 */
public GridView() { }

/**
 * The scene that is the content of the window (Stage).
 * 
 * @return		the scene
 */
public Scene getScene()
{
	return scene;
}

/**
 * Build the window, and initiate the processing. Tell the controller where to find
 * its view
 *
 * @param stage		stage (window) supplied by JavaFX
 */
@SuppressWarnings("Convert2Lambda")
@Override
public void start(Stage stage)
{
	/* Establish a root node. */
	Pane root = new Pane();
	root.setStyle("-fx-background-color: #EEEEEE");
	/* The scene contains the root ... */
	scene = new Scene(root);
	/* ... and the stage (window) contains the scene. Tell the message display
	   code. */
	stage.setScene(scene);
	MessageDisplay.setStage(stage);
	
	/* Get the parameter values from the launch method, or, if there are no
	   commandline values, ask the user for a pair of values. If there is still no
	   values, use the default values. */
	Application.Parameters params = getParameters();
	List<String> values = params.getRaw();
	
	/* Create and remember the controller. */
	this.controller = new GridController(this, values);
	controller.initialize(null, null);


	/* Get the canvas, and then add that component to the window as its only
	   content. */
	Canvas canvas = controller.getCanvas();
	root.getChildren().add(canvas);
	root.setPrefSize(canvas.getWidth(), canvas.getHeight());

	/* Title the window. */
	stage.setTitle(controller.getTitle());
	/* Initiate the showing of the window using the Event Dispatch Thread. */
	stage.show();
	/* Allow the window to be resized after starting. */
	stage.setMinWidth(stage.getWidth());
	stage.setMinHeight(stage.getHeight());
	stage.setResizable(true);
	root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	/* If there is a message, show it. */
	if( message != null )
			MessageDisplay.displayMessage(INFORMATION, "Values changes", message);	
}

/**
 * Any starting message to be displayed once the window is in place.
 * 
 * @param message	the message
 */
public void setMessage(String message)
{
	this.message = message;
}

/**
 * Pop up a message dialog, to display an error message.
 *
 * @param observable	the object issuing the update
 * @param message			 the message to display
 */
@Override
public void update(Observable observable, Object message)
{
	MessageDisplay.displayMessage("Error in Value", (String) message);
}
}
