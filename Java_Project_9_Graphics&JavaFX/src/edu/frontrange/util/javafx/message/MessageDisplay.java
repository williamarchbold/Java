
package edu.frontrange.util.javafx.message;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import static javafx.application.Platform.runLater;
import static javafx.scene.control.Alert.AlertType.ERROR;

/**
 * This class defines a {@code displayMessage} method for creating an Alert dialog,
 * with controls to ensure that multiple messages do not display at the same time.
 * The dialog is always shown on the EDT (the Platform thread). It also defines
 * an {@code inputMessage} method for obtaining a single String input from the
 * user.
 *
 * @author		Dr. Bruce K. Haddon, Instructor
 * @version		3.0, 2018-02-14
 */
public class MessageDisplay
{
/**
 * Flag for ensuring only one message is showing at a time.
 */
private static final AtomicBoolean MESSAGE_SHOWING = new AtomicBoolean(false);

/**
 * Default location for the display of the message.
 */
private static Stage stage;

/**
 * Constructor: private to prevent instantiation
 */
private MessageDisplay() {}

/**
 * Called when the view should display an error message.
 *
 * @param title			title to appear with the message
 * @param message		the message to display
 */
@SuppressWarnings({ "Convert2Lambda", "ResultOfObjectAllocationIgnored" })
public static void displayMessage(final String title, final String message)
{
	displayMessage(ERROR, title, message);
}

/**
 * Called when the view should display an message of a particular type.
 *
 * @param alertType		CONFIRMATION, ERROR, INFORMATION, NONE, WARNING
 * @param title			title to appear with the message
 * @param message		the message to display
 */
@SuppressWarnings({ "Convert2Lambda", "ResultOfObjectAllocationIgnored" })
public static void displayMessage(final AlertType alertType,
										final String title, final String message)
{
	/* Do not show another message if there is already a message showing. */
	if( MESSAGE_SHOWING.compareAndSet(false, true) )
	{
		new JFXPanel();					// ensure JavaFX is running
		runLater(new Runnable()
		{
			/**
			 * This run method is executed on the EDT
			 */
			@Override
			public void run()
			{
				Alert alert = new Alert(alertType, message);
				if( title != null ) alert.setHeaderText(title);
				/* This is to ensure the alert is seen on top of all windows. */
				((Stage) alert.getDialogPane().
									getScene().getWindow()).setAlwaysOnTop(true);
				/* The given stage cannot be the owner if it is not showing. */
				if( stage != null && stage.isShowing() ) alert.initOwner(stage);
				alert.showAndWait();
				/* When user dismisses the dialog, the message showing is over. */
				MESSAGE_SHOWING.set(false);
			}
		});
	}
}

/**
 * Create the place in which the messages will be shown.
 *
 * @param stage		the window for the application
 */
public static void setStage(Stage stage)
{
	MessageDisplay.stage = stage;
}

/**
 * Called when some input {@code String} is required from the user.
 * 
 * @param title		title for the input dialog
 * @param message	to the user as to what input is required
 * @return			the input created by the user, or null if the dialog is 
 *					canceled.
 */
@SuppressWarnings("ResultOfObjectAllocationIgnored")
public static String inputMessage(final String title, final String message)
{			
	new JFXPanel();					// ensure JavaFX is running

	if( MESSAGE_SHOWING.compareAndSet(false, true) )
	{
		TextInputDialog input = new TextInputDialog();
		if( title != null ) input.setTitle(title);
		if( message != null ) input.setHeaderText(message);
		/* This is to ensure the input request is seen on top of all windows. */
		((Stage) input.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
		/* The given stage cannot be the owner if it is not showing. */
		if( stage != null && stage.isShowing() ) input.initOwner(stage);
		Optional<String> result = input.showAndWait();
		/* When user dismisses the dialog, the message showing is over. */
		MESSAGE_SHOWING.set(false);
		return result.isPresent() ? result.get() : null;
	}
	return null;
}

/**
 * Optimization: allow for the short-circuit of some work if there is a message
 * showing that has not yet been dismissed by the user.
 *
 * @return		true if there is a message showing
 */
public static boolean isMessageShowing()
{
	return MESSAGE_SHOWING.get();
}
}
