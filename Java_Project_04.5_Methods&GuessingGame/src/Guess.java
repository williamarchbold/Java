import java.util.Scanner;
import java.util.Random;

/**
 * Class Guess will represent one game of the Guessing Game
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-18 CSC 240, Assignment 4 Guess.java
 */

public class Guess { //make public class so others can use
    
    private final int lowerLimit;
    
    private final int upperLimit;
    
    private final Scanner source;
    
    private static final Random RANDOM = new Random(); //instance called RANDOM of type Random from class Random
    
    public Guess(Scanner source, int lowerLimit, int upperLimit) { //constructor for an instance of object Guess
        
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.source = source;    
    }
    
    public final void play () { //feedback from assignment recommended making public methods final 
        
        int r = lowerLimit + RANDOM.nextInt((upperLimit-lowerLimit)+1); // declare int variable that
            //becomes a random int between lower limt and difference between lower and upper plus one
        
        System.out.printf("In this game, you must guess what the random number "
                + "is between %d and %d. Please enter your first "
                + "guess:  ", lowerLimit, upperLimit);
        
        int guess  = source.nextInt(); //method of input object finds next integer and assigns it to variable
        
        int totalGuesses = 0;
        
        for (;;) { //this is an infinite loop and requires a break statement to get out of
            
            ++totalGuesses; //keep track of total guesses 
            
            if (guess < r) {              
                System.out.print("\nToo low. Guess again (0 to quit): ");
            }
            if (guess > r) {               
                System.out.print("\nToo high. Guess again (0 to quit): ");
            }
            if (guess == r) {               
                System.out.print("\nCongratulations. You guessed the number!");
                break;
            }
            guess = source.nextInt(); //assign next user input to variable
            if (guess == 0) { //give opportunity to quit
                break;
            }
        }
        
        if (totalGuesses < 10) { //output this if player is really good
            System.out.print("Either you know the secret or you were lucky!");
        }
        if (totalGuesses == 10) { //ouput this if player knows secret
            System.out.print("Aha! You know the secret!");
        }
        if (totalGuesses > 10) { //output this if player doesn't know what they're doing
            System.out.print("You should be able to do better!");
        }
        
    }
}