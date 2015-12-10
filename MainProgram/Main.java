import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
public class Main {
	public static void main(String[] Args) throws InputMismatchException {
		Scanner input = new Scanner(System.in);
		int humRow;
		int humCol;
		char humInput = 'X';

		
		int answer = 1;
		
		String statement;
		do  {																	//This loop will continue to run till the player decides they do not want to continue

			Boolean referee = false; 								
			Memory Memory = new Memory();
			while (referee == false) {											//This loop continues to play till referee decides there is a winner or a tie

				boolean loop = false;
				while (loop == false) {											//This loop runs till there are no exceptions
					try {

						humRow = '\u0000';
						humCol = '\u0000';
						System.out.println("Please enter a number from 1 to 3 for the row.");
						humRow = input.nextInt();
						System.out.println("Please enter a number from 1 to 3 for the Column.");
						humCol = input.nextInt();
						humRow--;
						humCol--;
						Memory.Storage(humRow, humCol, humInput);

						loop = true;

					} catch (IOException overlap) {												// if  Memory.Storage throws an exception this catch statement prints this
						System.out.println("Please choose a spot that is not taken.");
					} catch (NoSuchElementException outOfBounds) {								// catches exception if number is out of bounds or if wrong data type is entered.
						System.out.println("Please choose a Row and Column between 1 and 3");
						input.next();
					}

				}

				Memory.gameBoard();											//game board is printed with current entries
				referee = Memory.referee();									// referee evaluates if there is a winner
				if (referee == true){										// if condition breaks the loop if referee establishes a winner
					break;
				}
				Memory.AI();												//AI enters its answer
				referee = Memory.referee();									// referee evaluates if there is a winner
				Memory.gameBoard();											// game board is printed with current entries
			}
			statement = Memory.statement();									// statement is assigned to what the statement method is assigned
			
			boolean game = false;
			while (game == false) {											// a while loop is established to catch exceptions for the user entry to see if they want to play again
				try {
					System.out.printf("%s\n", statement);
					System.out.println("Would you like to play again? Press 1 for yes and any other whole number for no.");
					
					answer = input.nextInt();
					if (answer == 1){
						break;
					}
					
					
				} catch (Exception wrongEntry) {
					System.out.println("Please enter a number. 1 for yes and any other whole number for no");
				}
				
			}
			
			

		}while(answer == 1);
	}
}
