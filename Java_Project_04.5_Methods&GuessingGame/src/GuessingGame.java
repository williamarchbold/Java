import java.util.Scanner;

/**
 * Guessing Game Class will ask you if you want to play a game. If yes it will 
 * launch Guess.java else it will quit
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-18 CSC 240 Lesson 4 GuessingGame.java
 */

public class GuessingGame {
    
    public static void main(String...args) {
        
    Scanner input = new Scanner(System.in); //create an object called input of type and class Scanner
        
    Guess game = new Guess(input, 0, 1000); //create an instance of class Guess with 3 paramaters
        
    System.out.print("Would you like to play the Guessing Game? 1 for yes. 2"
             + "for no:");
     
    
     
     int play = input.nextInt();
     
     while (play == 1) {
         
         game.play(); //use the method from class Guess on instance game
        
        System.out.print("\n\nWould you like to play the Guessing Game again? 1 for yes. 2"
            + " for no: ");
        play = input.nextInt();
     }
    input.close(); //no longer need to read input so close it
    }
}