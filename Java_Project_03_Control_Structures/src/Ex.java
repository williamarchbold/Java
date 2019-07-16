import java.util.Scanner;

/**
 * This program computes an estimate of the value of mathematical value e^x
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-09, CSC 240 Assignment 3 Part 2 Ex.java
 */

public class Ex {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive number of terms (or 0 to quit):  ");
        
        int n = input.nextInt();
        
        while (n != 0) {
            
            while (n < 0) {
                
                System.out.print("\nInvalid input. Enter a positive number of"
                    + " terms (or 0 to quit):  ");
                
                n = input.nextInt();             
            }
            if (n == 0) {
                break;
            }
            
            System.out.print("\nEnter an exponent (positive, zero or fractional): ");
            
            double x = input.nextDouble();
            
            while (x < 0) {
                System.out.print("\nInvalid input. Enter a positive number of"
                    + " terms (or 0 to quit):  ");    
            if (n == 0) {
                break;
            }
            System.out.print("\nEnter an exponent (positive, zero or fractional): ");
            
            x = input.nextDouble();
            }
            
            double sum = 1.0D;                                
            double xpow = x;
            double fact = 1;
            for ( int i = 1; i < n; i++ ) {
                sum += xpow / fact;
                
                xpow *= x;
                fact *= i+1;
                if (Double.isNaN(sum) || Double.isInfinite(sum)) {
                    break;
                }
            }
                        
            if (Double.isNaN(sum) || Double.isInfinite(sum)) {
            System.out.printf("\nAfter %d terms estimate of e to the power %f cannot be computed.", n, x);
            }
            else {
            System.out.printf("\nAfter %d terms estimate of e to the power %f"
            + " is %.15g", n, x, sum);
            }
            
        System.out.print("\n\nEnter a positive number of terms (or 0 to quit):  ");
        n = input.nextInt();
        }
    }
}
