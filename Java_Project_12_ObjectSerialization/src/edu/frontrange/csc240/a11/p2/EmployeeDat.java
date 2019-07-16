
package edu.frontrange.csc240.a11.p2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * This class uses the Employee and Date classes to create Employee objects, but 
 * also serialize the data and store in .dat files. 
 * 
  *@author William Archbold, S02369823
 * @version 2018-11-24, CSC-240 Assignment 11 Part 2 EmployeeDat.java 
 */
public class EmployeeDat {
    
 /**
 * The file to be used to write serialized (binary) records of the objects, and
 * to read them back.
 */
    public void run() {
        try {
            File binaryFile = new File("Employees.dat");
    
            try (ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(binaryFile))) { 
                
                /*Create array of type Employee to store 5 employees in */
                Employee[] employees = new Employee[] 
                {
                         new Employee("John", "Doza", new Date(2, 15, 1987), new Date(2, 17, 1988)),
                         new Employee("Steve", "Mann", new Date(9, 23, 1986), new Date(4, 27, 1987)),
                         new Employee("Mike", "Patts", new Date(2, 25, 1985), new Date(1, 11, 1998)),
                         new Employee("Sarah", "Smith", new Date(12, 29, 1977), new Date(2, 27, 1985)),
                         new Employee("Kristen", "Strong", new Date(5, 10, 1963), new Date(5, 12, 1999)),
                };
                                
                for( Employee testEmployee : employees ) {
                    outFile.writeObject(testEmployee);
                }
            }

            ArrayList<Employee> employees = new ArrayList<Employee> ();
            
            binaryFile = new File("Employees.dat");
            try( ObjectInputStream inFile =
				new ObjectInputStream(new FileInputStream(binaryFile)) )
		{
                    /* Read back students until an EOFException is thrown. */
                    while( true )
                            employees.add((Employee) inFile.readObject());
		} catch( EOFException ex ) {
		}
            
            ;

            try (PrintStream outputSummary = new PrintStream(new FileOutputStream("Summary.txt")))
            {
                for (Employee employee : employees) {
                    outputSummary.println(employee.toString());
                }
            }
            
        } catch(Exception ex) {
            System.out.println (ex);
        }
    }
    
    /**
    * Main entry point.
    * <p>
    * Execute: </p>
    * <pre>package edu.frontrange.csc240.a11.p2;</pre>
    *
    * @param args		unused
    */
    public static void main(String[] args) {
            new EmployeeDat().run();
    }
}
