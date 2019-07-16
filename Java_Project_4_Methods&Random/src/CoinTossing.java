import java.util.Scanner;

/**
 * This class simulates the tossing of  a coin as many times as the user wants
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-18, CSC 240 Assignment 4 CoinTossing.java
 */

public class CoinTossing { 
    
    public static void main(String... args){
        
        int headCount = 0; //initialize int variable to count # heads
        int tailsCount = 0; //initialize int variable to count # tails
        
        Scanner input = new Scanner(System.in); //create an object called input of type and class Scanner
                
        System.out.print("This program simulates the tossing of a coin and reports"
                + "the total number of times a coin comes up heads and tails. \n");
        
        System.out.print(("Enter the number of flips (0 to exit program): "));
        int tosses = input.nextInt(); 
        
        while (tosses != 0) { //allows user to break out of while loop
            
            for (int i = tosses; i > 0; i--) {
                
                Coin result = Coin.flip(); //Coin type static method flip returns a coin object or static instance
                
                switch (result) {
                    
                    case HEADS:
                        ++headCount;
                        break;
                    case TAILS:
                        ++tailsCount;
                        break;
                }
            }
            
            System.out.printf("Tossed %d coins.\n total tosses: %d\n "
                    + "total heads: %d \n total tails: %d\n\n", 
                    tosses, headCount + tailsCount, headCount, tailsCount);
            
            System.out.print(("Enter the number of flips (0 to exit program): "));
            tosses = input.nextInt(); //method of input object finds next integer and assigns it to variable
        }
    input.close(); //no longer need to read input so close it
    }
}