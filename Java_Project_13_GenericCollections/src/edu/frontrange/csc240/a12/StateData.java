package edu.frontrange.csc240.a12;

/**
 * This class stores geographic information about U.S. states and territories. 
 * Per the homework guidance, this class must add the clause implements Comparable
 * to define the 'natural order' on the data fields. Comparable must take one 
 * generic type argument which is the implementing class, StateData. 
 * 
 * @author William Archbold, S02369823
 * @version 2018-11-29, CSC-240 Assignment 12 StateData.java 
 */
public class StateData implements Comparable<StateData>{
    
    //Moved DELIMITER from the test class to the decleration class so it can be
    //used in other tests
    static final String DELIMITER = ",";
    
    /**
     * Per Lesson 12, Comparison paper, "every class has an equals method. Used
     * website below for guidance on how to implement proper equals method. 
     * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
     * @param obj 
     * @return True or False if the two objects are the same or not
     */
    @Override
    public boolean equals(Object obj) {
         // If the object is compared with itself then return true   
        if (obj == this) { 
            return true; 
        } 
  
         // Check if StateData is an instance of obj or not
        if (!(obj instanceof StateData)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        StateData c = (StateData) obj; 
          
        // Compare the data members and return accordingly  
        return this.name.equals(c.name) &&
               this.land == c.land && this.percentWater ==
                c.percentWater && this.water == c.water && this.totalSize ==
                c.totalSize;
    }
    /**
     * This method creates a natural order for comparing. Use compareToIgnoreCase
     * rather than compareTo because homework guidance says to ignore case. 
     * @param o As per Lesson 12's Comparison page "They type of the parameter 
     *          to the compareTo method is the type of the containing class"
     * @return  Will return -1,0 or 1 (less than, equal to, greater than)
     */
    @Override
    public int compareTo(StateData o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    /**
     * Based on the Lesson 12 Comparison page, hashCode Override example. 
     * @return An integer summation of the hash of the fields of the State Data instance
     */
    @Override
    public int hashCode() {
        return this.name.hashCode()+Double.hashCode(this.totalSize)+Double.hashCode(this.land)
                +Double.hashCode(this.water)+Double.hashCode(this.percentWater); 
    }
    
    private String name;
    private double totalSize;
    private double land;
    private double water;
    private double percentWater;
    
    /**
     * Constructor for a StateData object
     * @param name
     * @param totalSize
     * @param land
     * @param water
     * @param percentWater 
     */
    public StateData(String name, double totalSize, double land, double water, double percentWater) {
        this.name = name;
        this.totalSize = totalSize;
        this.land = land;
        this.water = water;
        this.percentWater = percentWater;
    }
    
    /**
     * Concatenates all the fields of a StateData object into a string. 
     * @return string 
     */
    @Override
    public String toString(){
        String string = String.format("%40s %-10.2f %-10.2f %-10.2f %-10.2f", 
                this.name, this.totalSize, this.land , this.water, this.percentWater);
        return string;
    }
    
    /**
     * Method retrieve the totalSize field for the instance. 
     * @return double totalSize 
     */
    public double getTotalSize(){
        return this.totalSize;
    }
    
    /**
     * Method to retrieve the water field for the instance. 
     * @return double water
     */
    public double getWater(){
        return this.water;
    }
}
