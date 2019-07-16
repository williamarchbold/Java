import java.util.Scanner;

/**
 * This program calculates the factorial value an integer inputted by the user
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-08, CSC 240 Assignment 3 Part 1: Factorial
 */

public class Factorial {
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
 
        System.out.print("Please enter a non-negative integer. The program "
            + "will return the factorial value. Enter 0 to exit program: ");
            
        int number1 = input.nextInt();
        
        while (number1 != 0) {
            
            while (number1 < 0) {
                
                System.out.print("\n\nInvalid input. Try again or enter 0 to exit program: ");
                number1 = input.nextInt();
            }
            
            if (number1 == 0) {
                break;
            }
            
            long product = 1;
            
            for (int x = number1; x > 1; x--) {
                  
               product *= x;                                        
            }
            
            //product *= number1;
            
            System.out.printf("\n\nThe factorial of %d is %d \n\n", number1, product);
            
            System.out.print("Please enter a non-negative integer. The program "
            + "will return the factorial value. Enter 0 to exit program: ");
            
            number1 = input.nextInt();            
        }
        
        System.out.print("0!=1 \n Exiting program...\n\n");   
    }
}