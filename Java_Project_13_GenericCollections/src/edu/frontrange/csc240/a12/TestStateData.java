package edu.frontrange.csc240.a12;

import edu.frontrange.util.InputData;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * This class will create an instance of TestStateData. 
 * @author William Archbold, S02369823
 * @version 2018-11-29, CSC-240 Assignment 12 TestStateData.java 
 */
public class TestStateData {
    
    static final int VALUES_PER_LINE = 5;
    
    public void run(){
        
        InputData inputData = new InputData("Areas.csv", InputData.class, null,
        VALUES_PER_LINE, StateData.DELIMITER);
        List<StateData> list = new ArrayList<StateData>();
        
        //create an enumerator that goes through a line of Areas.csv and assigns each value to an index in a String array
        //then assign each index's value to a field in the new StateData object
        //each StateData object is then added to the list collection. 
        for ( String[] values : inputData) {
            StateData stateData = new StateData(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
            list.add(stateData);
        }
        
        //use method addAll per homework guidance to the trees. No normal argument
        //given so defaults to natural ordering
        TreeSet<StateData> treeSet1 = new TreeSet<>();
        treeSet1.addAll(list);
        
        //given a TotalAreaComparator constructor argument so that the tree knows
        //what to sort by
        TreeSet<StateData> treeSet2 = new TreeSet<>(new TotalAreaComparator());
        treeSet2.addAll(list);
        
        //given a WaterAreaComparator constructor argument so that the tree knows
        //what to sort by
        TreeSet<StateData> treeSet3 = new TreeSet<>(new WaterAreaComparator());
        treeSet3.addAll(list);
        
        System.out.println("Natural order:");
        int counter = 1;
        
        //I used the below website for guidance on how to iterate through the tree
        //and print out the string. 
        //https://stackoverflow.com/questions/10572706/how-to-print-objects-from-a-treeset
        for (StateData stateData : treeSet1) {
            System.out.printf("%3d ", counter);
            System.out.println(stateData.toString());
            counter++;
        }
        
        counter = 1;
        System.out.println();
        System.out.println("Total Area Decreasing:");
        for (StateData stateData : treeSet2) {
            System.out.printf("%3d ", counter);
            System.out.println(stateData.toString());
            counter++;
        }
        counter = 1;
        System.out.println();
        System.out.println("Water Area Increasing:");
        for (StateData stateData : treeSet3) {
            System.out.printf("%3d ", counter);
            System.out.println(stateData.toString());
            counter++;
        }
        
        
    }
    
    /**
    * Main entry point.
    * <p>
    * Execute:  </p>
    * <pre> java TestStateData.java </pre>
    *
    * @param args		unused
    */
    public static void main(String[] args) {
        new TestStateData().run();
    }
}
