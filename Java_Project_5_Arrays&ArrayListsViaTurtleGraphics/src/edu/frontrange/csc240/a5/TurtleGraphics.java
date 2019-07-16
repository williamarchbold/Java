
package edu.frontrange.csc240.a5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides methods for processing "turtle graphics" programs into
 * an executable form, and for executing that form.
 * <p>
 * The TurtleGraphics class takes a series of numeric commands from the user
 * to move a turtle around a 20x20 floor and draw asterisks while it moves if there
 * is an active command to draw. The user can also lift the pen and have the turtle 
 * move without drawing anything. 
 *
 * @author William Archbold, S02369823
 * @version 2018-10-02, CSC-240 Assignment 5 TurtleGraphics.java
 */
public class TurtleGraphics
{

/* This list reference variable is outside any method because it will be 
    used in both methods
    */
private List<Integer> instructions; 

/**
 * Accepts a turtle program from a Scanner.
 *
 * @param source	Scanner that is the source of Turtle commands
 * @return			List of messages about the compilation (not null)
 */
public List<String> enterCommands(Scanner source)
{
	source.useDelimiter("(\\s)+|,(\\s)*"); //this will ignore commas
	List<String> messages = new ArrayList<>(); //store messages in this array
        instructions = new ArrayList<>(); //assign variable to a new array list
	while( source.hasNextInt() ) //loop until no more source ints
	{
		int next = source.nextInt();
                switch (next) {
                    case 1:
                        messages.add("" + next);
//                        break;
                    case 2:
                        messages.add("" + next);
  //                      break;                       
                    case 3: 
                       messages.add("" + next);
//                        break;                       
                    case 4: 
                       messages.add("" + next);
                    case 6:
                        instructions.add(next);
                        break;
                    case 5:
                        instructions.add(next);
                        if (source.hasNextInt()) {
                            int distance = source.nextInt();
                            messages.add("" + next + ", " + distance);
                            instructions.add(distance);
                        }
                        else {
                            messages.add(""+next+"[MOVE has no value]"); 
                        }
                        break;
                    case 9: 
                        return messages;
                    default: 
                        messages.add(""+next+"[Invalid command]"); 
                }
                    
/*		String input = Integer.toString(next);
		if( next == MOVE && source.hasNextInt() )
				 messages.add(input + "," + source.nextInt());
		else
			messages.add(input);
*/
        }
        /*this handles nonnumeric input and early input that ends 
        too soon (w/out a 9)
            */
        if (source.hasNext()) {
            messages.add("[Non-numeric command]");
        }
        else{
            messages.add("[End command missing]");
        }
	return messages;
}

/**
 * Execute the commands that been entered via the enterCommands method.
 *
 * @return		false if the program cannot be executed, otherwise true
 */

enum Direction {RIGHT, DOWN, LEFT, UP}; 
enum Pen {UP, DOWN};

public boolean executeCommands()
{
	int x = 0;
        int y = 0;
        
        Pen pen = Pen.UP;
        Direction direction = Direction.RIGHT;  
    
        char[][] board = new char[20][20]; //board size doesn't change
    
    for (int i = 0; i < instructions.size(); i++) {
            
            int command = instructions.get(i);
            switch (command) {
                case 1: 
                    pen = Pen.UP;
                    break;
                case 2:
                    pen = Pen.DOWN;
                    break;
                case 3:
                    switch (direction) {
                        case RIGHT:
                            direction = Direction.DOWN;
                            break;
                        case DOWN:
                            direction = Direction.LEFT;
                            break;
                        case LEFT:
                            direction = Direction.UP;
                            break;
                        case UP:
                            direction = Direction.RIGHT;
                            break;
                    }
                    break;
                        
                case 4:
                    switch (direction) {
                        case RIGHT:
                            direction = Direction.UP;
                            break;
                        case DOWN:
                            direction = Direction.RIGHT;
                            break;
                        case LEFT:
                            direction = Direction.DOWN;
                            break;
                        case UP:
                            direction = Direction.LEFT;
                            break;
                    }
                    break;                    
                case 5:
                    i++;
                    int distance = instructions.get(i);
                    for (int j = 0; j < distance; j++) {
                        if (pen == pen.DOWN) {
                            board[x][y] = '*';
                        }
                        switch (direction) {
                            case UP:
                                y--;
                                if (y < 0) {
                                    System.out.println("Turtle went off the floor");
                                    return false;
                                }
                                break;
                            case DOWN:
                                y++;
                                if (y >= 20) { //if x goes off the board                               
                                    System.out.println("Turtle went off the floor");
                                    return false;
                                }
                                break;
                            case RIGHT:
                                x++;
                                if (x >= 20) { //if x goes off the board                               
                                    System.out.println("Turtle went off the floor");
                                    return false;
                                }
                                break;
                            case LEFT:
                                x--;
                                if (x < 0) { //if x goes off the board
                                    System.out.println("Turtle went off the floor");
                                    return false;
                                }
                                break;
                        }
                    }
                    break;
                case 6:
                    displayBoard(board);
                    break;
                case 9:
                    return true;
                default:
                    throw null;
                    
                 
            }
        }
	return false;
}

/*
 * This method will display the board and where the turtle has gone   
 * @param board 	two dimensional char array board 
 * @return void             
*/
private void displayBoard(char[][] board) {
    for (int y = 0; y < 20; y++) {
        for (int x = 0; x < 20; x++) {
            if (board[x][y] == '*') {
                System.out.print("* ");
            }
            else {
                System.out.print("  ");
            }
        }
        System.out.println();
}
}
}
