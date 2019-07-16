
package edu.frontrange.csc240.a6;

/**
 * This enumeration class provides the course prefixes that will be used to 
 * create Course objects
 * @author William Archbold, S02369823
 * @version 2018-10-09, CSC-240 Assignment 6 Prefix.java
 */
public enum Prefix {
    //declare 4 constants of enum type that represent the 4 available prefixes
    //and pass the full course title to the constructor to attach the titles
    CIS("Computer Information Systems"),
    CNG("Computer Networking"),
    CSC("Computer Science"), 
    CWB("Computer Web-based");
    
    private final String title;
    
    
    /** 
    * private enum constructor for a Prefix. Private so that no one can change
    * the associated title with the prefix
    * 
    * @param title The full title associated with a certain prefix
    */
    private Prefix(String title) {
        
        this.title = title;  
    }
    
    /** 
     * Accessor for field title
     * 
     * @return title The full title of a course
     */
    public String getTitle() {
        return title;
    }
}
