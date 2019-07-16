import java.util.Scanner;

/**
 * This program calculates the total price of an order
 * 
 * @author William Archbold, S02369823
 * @version 2018-09-09, CSC 240 Assignment 3, Part 3 CalculatingSales.java
 */

public class CalculatingSales {
    public static void main(String[] args) {
        
        double total = 0.0;
        int quantity = 0;
        int soap = 0;
        int shampoo = 0;
        int lotion = 0;
        int conditioner = 0;
        int moisturizer = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a product number from 1 to 5 (or 0 to stop): ");
            
        int selection = input.nextInt();
        
        while (selection != 0) {
            
            switch (selection) {
                
                case 0: 
                    break; 
                
                case 1:                   
                    System.out.print("Enter quantity ordered: ");
                    quantity = input.nextInt();
                    if (quantity < 0) {
                        System.out.print("Quantity may not be negative. Please continue.\n");
                        break;   
                    }
                    soap += quantity;
                    break;
                    
                case 2:
                    System.out.print("Enter quantity ordered: ");
                    quantity = input.nextInt();
                    if (quantity < 0) {
                        System.out.print("Quantity may not be negative. Please continue.\n");
                        break;   
                    }
                    shampoo += quantity;
                    break;
                    
                case 3:
                    System.out.print("Enter quantity ordered: ");
                    quantity = input.nextInt();
                    if (quantity < 0) {
                        System.out.print("Quantity may not be negative. Please continue.\n");
                        break;   
                    }
                    lotion += quantity;
                    break;
                    
                case 4:
                    System.out.print("Enter quantity ordered: ");
                    quantity = input.nextInt();
                    if (quantity < 0) {
                        System.out.print("Quantity may not be negative. Please continue.\n");
                        break;   
                    }
                    conditioner += quantity;
                    break;
                    
                case 5: 
                    System.out.print("Enter quantity ordered: ");
                    quantity = input.nextInt();
                    if (quantity < 0) {
                        System.out.print("Quantity may not be negative. Please continue.\n");
                        break;   
                    }
                    moisturizer += quantity;
                    break;
                
                default: 
                    System.out.print("No product available with that ID.\n");
            }
            System.out.print("Enter a product number from 1 to 5 (or 0 to stop): ");
            
            selection = input.nextInt();   
        }
        
        System.out.printf("\n\n%5s%5s%20s%5s%10s\n", "|", "Item", "| Quantity |", 
                " Price", " | Extension |");
        System.out.print("     --------------------------------------------|\n");
        
        if (soap > 0) {
            System.out.printf("   1| Soap %8s%9d |%4s%10.2f |\n","|", soap, "  2.98 |", soap*2.98);
        }
        if (shampoo > 0) {
            System.out.printf("   2| Shampoo %5s%9d |%4s%10.2f |\n", "|", shampoo, "  4.50 |", shampoo*4.50);
        }
        if (lotion > 0) {
            System.out.printf("   3| Lotion %6s%9d |%4s%10.2f |\n", "|", lotion, "  9.98 |", lotion*9.98);
        }                
        if (conditioner > 0) {
            System.out.printf("   4| Conditioner %1s%9d |%4s%10.2f |\n", "|", conditioner, "  4.49 |", conditioner*4.49);
        } 
        if (moisturizer > 0) {
            System.out.printf("   5| Moisturizer %1s%9d |%4s%10.2f |\n", "|", moisturizer, "  6.87 |", moisturizer*6.87);
        }
        System.out.print("     --------------------------------------------|\n");
        System.out.printf("%39s%9.2f%s\n", "Total for order | ", (soap*2.98)+(shampoo*4.50)+(lotion*9.98)+(conditioner*4.49)+(moisturizer*6.87), " |");
    }
}