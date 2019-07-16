package edu.frontrange.csc240.a12;

import java.util.Comparator;

/**
 * This class will compare the water area fields of two StateData objects as per
 * the homework guidelines to define external orderings. 
 * @author William Archbold, S02369823
 * @version 2018-11-29, CSC-240 Assignment 12 WaterAreaComparator.java 
 */
public class WaterAreaComparator implements Comparator<StateData> {

     /**
     * Compare method uses a decreasing water area comparator. 
     * @param o1
     * @param o2
     * @return negative int if first parameter object is less than second, 0 if same, 
     */
    @Override
    public int compare(StateData o1, StateData o2) {
        int result = Double.compare(o1.getWater(),o2.getWater());
        if (result != 0)
            return result;
        return o1.compareTo(o2);
    }
    
}
