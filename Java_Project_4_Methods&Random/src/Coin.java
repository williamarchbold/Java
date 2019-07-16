import java.util.Random;

/**
 * The Coin class enumerates the two faces of a coin and provides a method for 
 * simulating the flipping of a coin
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-17, CSC-240 Assignment 4 Coin.java
 */


public enum Coin { HEADS, TAILS; //enumerate two possible sides of a coin. enumeration is like class creation

private static final Random RANDOM = new Random(); //new object from Random that user shouldn't access.

public static Coin flip() { //function that doesn't require an instance of a Coin (static)
    
    int r = 1 + RANDOM.nextInt(2); //declare variable that can be value 1 or 2
    
    if (r == 1) { //if 1 return Heads
        return HEADS;         
    }
    else { //if 2 return Tails
        return TAILS;
    }
}
    
}