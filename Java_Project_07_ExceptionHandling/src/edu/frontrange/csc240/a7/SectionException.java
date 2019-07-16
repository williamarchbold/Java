/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frontrange.csc240.a7;

/**
 * This class handles exceptions thrown from the Section class and passes those
 * exceptions to the base class.  
 * @author William Archbold, S02369823
 * @version 2018-10-16, CSC-240 Assignment 7 SectionException.java
 */
public class SectionException extends Exception {
    
    public SectionException(String message) {
        super(message);
    }
    public SectionException(String message, Throwable object) {
        super(message, object);
    }
}
