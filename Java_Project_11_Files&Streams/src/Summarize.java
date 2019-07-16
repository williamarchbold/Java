
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;



/**
 * This class uses streams to demonstrate an example of writing to and reading from
 * a text file. The class uses 3 functions. Function writeValues will write 10,000
 * random numbers to text file via a print stream object. Function readValues 
 * will read data from the same text file, analyze the data and then output that
 * analysis onto another file. Function main will open and close all of the objects 
 * and call the other two methods. 
 * 
  *@author William Archbold, S02369823
 * @version 2018-11-21, CSC-240 Assignment 11 Part 1 Summarize.java 
 */
public class Summarize {                
    private static PrintStream dataValues;
    private static Scanner scannerInput;
    private static PrintStream outputSummary;
    private static final Random RANDOM = new Random(-1L);
    
    /**
     * This method first wraps text file FileOutputStream in 
     * a static PrintStream variable. Then calls the method writeValues using the 
     * Printstream object as a parameter and then closes the PrintStream object. A 
     * scanner object wraps the same text file to provide a means to read data 
     * from the text file and the values are read from it via the readValues method
     * which also outputs data to the method's second parameter - an outputstream
     * wrapping a text file.  
     */
    public void run(){
        try {
            dataValues = new PrintStream(new FileOutputStream("DataValues.txt"));
            writeValues(dataValues);
            dataValues.close();
            scannerInput = new Scanner(new FileInputStream("DataValues.txt"));
            outputSummary = new PrintStream(new FileOutputStream("Summary.txt"));
            readValues(scannerInput, outputSummary);
            scannerInput.close();
            outputSummary.close();
        } catch (Exception ex) {
            
        }        
    }
    
    /**
    * Main entry point.
    * <p>
    * Execute:  </p>
    * <pre> java Summarize.java </pre>
    *
    * @param args		unused
    */
    public static void main(String[] args) {
        new Summarize().run();
    }
    
    /**
     * This method uses an iterator to create 10,000 random double values and then
     * prints those values to the printstream object. 
     * 
     * @param dataValues this is where the values are written to
     */
    public static void writeValues(PrintStream dataValues) { 
        for (int j = 0; j < 10000; j++) {
            double pick = RANDOM.nextDouble();
            dataValues.println(pick);
        }      
    }

   /**
    * This method will iterate through reading each data point from the text file and
    * update some analysis of the same data. Then the method will print that data
    * to the second parameter's wrapped text file. 
    * 
    * @param dataValues 
    * @param summaryValues 
    */
    public static void readValues(Scanner dataValues, PrintStream summaryValues) {
        int totalValueCount = 0;
        double sum = 0;
        double largest = Double.MIN_VALUE;
        double smallest = Double.MAX_VALUE;
        
        while (dataValues.hasNextDouble()) {
            double pick = dataValues.nextDouble();
            totalValueCount++;
            sum += pick; 
            if (pick > largest) {
                largest = pick;
            }
            if (pick < smallest) {
                smallest = pick; 
            }
        }
        
        summaryValues.println("William Archbold");
        summaryValues.println("CSC-240-500 Programming in Java");
        Date date = new Date();
        summaryValues.println(date);
        summaryValues.printf("Count of values=%d%n", totalValueCount);
        summaryValues.printf("Sum of values=%.15f%n", sum);
        summaryValues.printf("Average=%.15f%n", sum/totalValueCount);
        summaryValues.printf("Maximum=%.15f%n", largest);
        summaryValues.printf("Minimum=%.15f%n", smallest);
    }
}








