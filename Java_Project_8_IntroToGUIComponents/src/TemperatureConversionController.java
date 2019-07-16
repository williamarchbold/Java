import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
/*import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.InputMethodEvent;
*/
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;

/**
 * The controller class is the part of the Model-View-Controller (MVC) design 
 * pattern that handles an application's processing logic. This particular 
 * controller will use the various buttons from the temperature conversion GUI
 * to create events, process those events, and output the results to the user. 
 * 
 * @author	William Archbold, S02369823
 * @version	2018-10-29, CSC-240 Assignment 8, TemperatureConversionController.java
 */

//Use an enum internal to the class that specifies the three different states
//of temperature
enum Temperature { Kelvin, Celsius, Fehrenheit };

public class TemperatureConversionController {
    
    //create two instance variables that reference the Fehrenheit enum Temperature
    Temperature fromTemp = Temperature.Fehrenheit, toTemp = Temperature.Fehrenheit;
    
    /**
     * Lines 39 - 73 declare the controller class's corresponding instance 
     * variables. The @FXML annotation that precedes each declaration indicates
     * that the variable name can be used in the FXML file that describes the
     * application's GUI.
     */
    
    @FXML
    private Label convertFromLabel;

    @FXML
    private Label convertToLabel;

    @FXML
    private RadioButton convertFromFahrenheitButton;

    @FXML
    private RadioButton convertFromCelsiusButton;

    @FXML
    private RadioButton convertFromKelvinButton;

    @FXML
    private RadioButton convertToFahrenheitButton;

    @FXML
    private RadioButton convertToCelsiusButton;

    @FXML
    private RadioButton convertToKelvinButton;

    @FXML
    private TextField convertFromTextField;

    @FXML
    private TextField convertToTextField;
    
    @FXML
    private ToggleGroup fromTempGroup;
    
    @FXML
    private ToggleGroup toTempGroup;
    
    

    /**
     * Lines 85-131 are methods that are used to process inputted data. Each method
     * corresponds to each of the nine possible combinations of conversion that 
     * can be done for example Celsius to Kelvin, Kelvin to Fehren..etc
     * @param event Execute when a mouse event or action event (moving of the mouse)
     * occurs
     */
    @FXML
    void convertFromValueChanged(ActionEvent event) {
        performConversion();
    }

    @FXML
    void convertFromValueChanged2(MouseEvent event) {
        performConversion();
    }


    @FXML
    void fromTemperatureBecomesCelsius(MouseEvent event) {
        fromTemp = Temperature.Celsius;
        performConversion();
    }

    @FXML
    void fromTemperatureBecomesFahrenheit(MouseEvent event) {
        fromTemp = Temperature.Fehrenheit;
        performConversion();
    }

    @FXML
    void fromTemperatureBecomesKelvin(MouseEvent event) {
        fromTemp = Temperature.Kelvin;
        performConversion();
    }

    @FXML
    void toTemperatureBecomesCelsius(MouseEvent event) {
        toTemp = Temperature.Celsius;
        performConversion();
 
    }

    @FXML
    void toTemperatureBecomesFahrenheit(MouseEvent event) {
        toTemp = Temperature.Fehrenheit;
        performConversion();
    }

    @FXML
    void toTemperatureBecomesKelvin(MouseEvent event) {
        toTemp = Temperature.Kelvin;
        performConversion();
    }
    
    
    /**
     * This method performs the actual conversion between any particular fromTemp
     * state and any desired endstate temperature. 
     */
    void performConversion() {
        //get the value the user inputted in the GUI
        String valueAsText = convertFromTextField.getText();
        //if empty text box
        if (valueAsText == null || valueAsText.length() == 0) {
            return;
        }
            
        double kelvinTemp = 0;
        double valueAsNumber = 0;
        //this handles any bad input that includes non numbers
        try {
            valueAsNumber = Double.parseDouble(valueAsText);
        } catch (Exception ex) {
           convertToTextField.setText("number is not numeric");
           return; 
        }
        
        //this switch will calculate the kelvin temp irrespective of which fromTemp
        //button is pushed
        switch (fromTemp) {
            case Fehrenheit:
                kelvinTemp = (5.0/9) * (valueAsNumber - 32) + 273.15;        
                break;
            case Celsius:
                kelvinTemp = valueAsNumber + 273.15;
                break;
            case Kelvin:
                kelvinTemp = valueAsNumber;
                break;
                
        }
        //use the Kelvin temp value to transform into any other possibly desired
        //values of toTemp
        double answer = 0;
        switch (toTemp) {
            case Fehrenheit:
                answer = (9.0/5) * (kelvinTemp - 273.15) + 32;
                break;
            case Celsius:
                answer = kelvinTemp - 273.15;
                break;
            case Kelvin:
                answer = kelvinTemp;
                break;            
        }
        
        //output the answer using two significant digits
        convertToTextField.setText(String.format("%.02f", answer)); 
    }
}