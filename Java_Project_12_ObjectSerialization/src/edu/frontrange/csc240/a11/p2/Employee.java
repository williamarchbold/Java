
package edu.frontrange.csc240.a11.p2;

import java.io.Serializable;

/**
 * Project specific holder for employees.  Modified to be Serializable.
 *
 * @author       Dr. Bruce K. Haddon, Instructor
 * @author       William Archbold,  S02369823  
 * @version      2.2, 2018-11-22, CSC-240 Assignment 11, per the 
 *               Assignment Instructions
 */
public class Employee implements Serializable {

private static final long serialVersionUID = 8328802856912343064L;
    

/**
 * Employee's date-of-birth.
 */
private final Date birthDate;

/**
 * Employee's first (or given) name.
 */
private final String firstName;

/**
 * This Employee's date-of-hire.
 */
private final Date hireDate;

/**
 * Employee's last (or family) name.
 */
private final String lastName;

/**
 * Constructor.
 * 
 * @param firstName		employee's first (or given) name
 * @param lastName		employee's last (or family) name
 * @param birthDate		employee's date-of-birth
 * @param hireDate		employee's date-of-hire
 */
public Employee(String firstName, String lastName, Date birthDate, Date hireDate)
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthDate = birthDate;
	this.hireDate = hireDate;
}

/**
 * Employee details (name, hire date, birth date)
 *
 * @return	employee details (name, hire date, birth date)
 */
@Override
public String toString()
{
	return String.format("%s, %s  Hired: %s  Birthday: %s", lastName, firstName,
			hireDate, birthDate);
}
}
