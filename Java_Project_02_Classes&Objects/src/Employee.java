
import static java.lang.System.out;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee class, to meet the requirements stated in the Assignment
 * Instructions for Assignment 2.
 * <p>
 * The following UML is given for this class: </p>
 * <p>
 * <strong><u>Employee</u> <br>
 * - firstNameField: String <br>
 * - lastNameField: String <br>
 * - salaryField: double <br>
 * <br>
 * +&lt;constructor&gt; Employee(firstName: String, lastName: String,
 * initialSalary: double) <br>
 * + setFirst(firstName: String) <br>
 * + setLast(lastName: String) <br>
 * + setMonthlySalary(salary: double) <br>
 * + getFirst(): String <br>
 * + getLast(): String <br>
 * + getMonthlySalary(): double <br>
 * + displayValues() <br>
 * + toString() : String </strong></p>
 *
 * @author	William Archbold, S02369823
 * @version	2018-09-05, CSC-240 Assignment 2, Exercise 3.13
 */
public class Employee {

private String firstNameField; //The employee's first name (assuming Western World naming).

private String lastNameField; //The employee's last name (assuming Western World naming).

private double salaryField; //Employee's monthly salary (assuming USA dollars).

/**
 * Constructor.
 *
 * @param firstName     employee's first name (assuming Western World naming)
 * @param lastName      employee's last name (assuming Western World naming)
 * @param initialSalary	employee's monthly initial salary (assuming USA dollars)
 */
public Employee(String firstName, String lastName, double initialSalary) {
	
        this.setFirst(firstName); //call method to set first name
        this.setLast(lastName); //call method to set last name
        this.setMonthlySalary(initialSalary); //call method to set monthly salary
    
}

/**
 * Print on the standard output the details (as specified elsewhere) of this
 * employee.
 */
public void displayValues()
{
	out.print("Employee: ");
        if (this.firstNameField == null) { //if first name is null value
            out.print("<Invalid first name> "); 
        }
        else { //output this if not null 
            out.printf("%s ", this.firstNameField);
        }
        if (this.lastNameField == null) { //if last name is null value 
            out.print("<Invalid last name>");
        }
        else { //output below if not null
            out.printf("%s", this.lastNameField); 
        }
        
        out.printf("; Monthly Salary: %.2f; ", this.salaryField);
        out.printf("Yearly Salary: %.2f\n", (this.salaryField * 12.0)); //print salary times 12 with 2 decimal places
}

/**
 * Getter for the employee's first name (assuming Western World naming).
 *
 * @return	employee's first name.
 */
public String getFirst()
{
        return this.firstNameField;
}

/**
 * Setter for the employee's first name (assuming Western World naming).
 *
 * @param firstName	employee's first name (assuming Western World naming).
 */
public void setFirst(String firstName)
{
        if (firstName == null || firstName.length() == 0) { //check for null first then 0 length
            out.println("Error in setting object: first name is a null or empty String");
            this.firstNameField = null;
        }
        else {
            this.firstNameField = firstName;
        }
}

/**
 * Getter for the employee's last name (assuming Western World naming).
 *
 * @return	employee's last name.
 */
public String getLast()
{
        return this.lastNameField;        
}

/**
 * Setter for the employee's last name (assuming Western World naming).
 *
 * @param lastName	employee's last name (assuming Western World naming).
 */
public void setLast(String lastName)
{
        if (lastName == null || lastName.length() == 0) { //check for null first then length
            out.println("Error in setting object: last name is a null or empty String");
            this.lastNameField = null;
        }
        else {
            this.lastNameField = lastName;
        }
}

/**
 * Getter for the monthly salary.
 *
 * @return	the value of the monthly salary
 */
public double getMonthlySalary()
{    
    return this.salaryField;
}

/**
 * Setter for the monthly salary.
 * <p>
 * @param salary	the monthly salary
 */
public void setMonthlySalary(double salary)
{
	if (salary < 0.0) { //guard if salary is incorrectly negative
            out.println("Salary cannot be negative. Salary set to $0");
            this.salaryField = 0.0;
        }
        else {
            this.salaryField = salary;
        }
}

/**
 * String identifying and describing this employee (as specified elsewhere).
 *
 * @return the string
 */
@Override
public String toString()
{ 
        return super.toString() + " " + this.firstNameField + " " + this.lastNameField; //call super toString then concatenate instance's data
}
}