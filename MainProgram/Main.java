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
		char compInput = 'O';
		
		int answer = 1;
		String skip;
		
		String statement;
		do  {
			System.out.println("Hello, we are going to play a game of tic tac toe.");
			Boolean referee = false;
			Memory Memory = new Memory();
			while (referee == false) {

				boolean loop = false;
				while (loop == false) {
					try {

						humRow = '\u0000';
						humCol = '\u0000';
						System.out.println("Please enter the row.");
						humRow = input.nextInt();
						System.out.println("Please enter the Column.");
						humCol = input.nextInt();
						humRow--;
						humCol--;
						Memory.Storage(humRow, humCol, humInput);

						loop = true;

					} catch (IOException overlap) {
						System.out.println("Please choose a spot that is not taken.");
					} catch (NoSuchElementException outOfBounds) {
						System.out.println("Please choose a Row and Column between 1 and 3");
						input.next();

					}

				}

				Memory.gameBoard();
				referee = Memory.referee();
				if (referee == true){
					break;
				}
				Memory.AI();
				referee = Memory.referee();
				Memory.gameBoard();
			}
			statement = Memory.statement();
			
			boolean game = false;
			while (game == false) {
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
