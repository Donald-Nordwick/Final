import java.io.IOException;
import java.util.NoSuchElementException;

public class Memory {
	private char[][] TicTacToe = new char[3][3];			//contains all the locations and their respective values in the game

	private String statement;								// contains the statement for the end of the game

	public Memory() {
		System.out.println("Hello, we are going to play a game of tic tac toe.");

	}

	public void Storage(int Row, int Col, char input) throws IOException {			//method that takes in the values from the computer and human inputs
		try {
			if ((Row < 0) || (Row > 2) || (Col < 0) || (Col > 2)) {					//throws an exception if the entry is not within the corret boundaries
				throw new NoSuchElementException();
			}
			if (TicTacToe[Row][Col] != '\u0000') {									//throws an exception if the entry already contains an X or an O
				throw new IOException();
			} else {
				TicTacToe[Row][Col] = input;										//assigns the user value if the previous conditions aren't triggered
			}
		} finally {
		}

	}

	public void gameBoard() {													//prints game board with values
		System.out.printf("___________\n");
		for (int i = 0; i < 3; i++) {
			System.out.printf(" %c | %c | %c \n", TicTacToe[i][0], TicTacToe[i][1], TicTacToe[i][2]);	//uses for loop to print board
			System.out.printf("___________\n");
		}
	}

	public boolean referee() {										//determines if there is a winner and who won or if there is a tie. If a conclusion is reached then statement is assigned a response.
		boolean response = false;
		for (int i = 0; i < 3; i++) {																//for loop is used to evaluate the rows and column to see if there is a winner across or down.
			if ((TicTacToe[i][0] == TicTacToe[i][1]) && (TicTacToe[i][1] == TicTacToe[i][2])) {
				if (TicTacToe[i][0] != '\u0000') {
					response = true;
					if (TicTacToe[i][0] == 'X') {
						statement = "Congrats you won!!1/1";
						break;
					} else {
						statement = "Sorry, you lost.1/2";
						break;
					}
				}
			} else if ((TicTacToe[0][i] == TicTacToe[1][i]) && (TicTacToe[1][i] == TicTacToe[2][i])) {
				if (TicTacToe[0][i] != '\u0000') {
					response = true;

					if (TicTacToe[0][i] == 'X') {
						statement = "Congrats you won!!2/1";
						break;
					} else {
						statement = "Sorry, you lost.2/2";
						break;
					}
				}
			}

		}

		if ((TicTacToe[0][0] == TicTacToe[1][1]) && (TicTacToe[1][1] == TicTacToe[2][2])) {				//if statement sees if there is a winner diagonally
			if (TicTacToe[0][0] != '\u0000') {
				response = true;
				System.out.println("1");
				if (TicTacToe[0][0] == 'X') {
					statement = "Congrats you won!!3/1";
				} else {
					statement = "Sorry, you lost.3/2";
				}
			}
		}else if ((TicTacToe[2][0] == TicTacToe[1][1]) || (TicTacToe[1][1] == TicTacToe[0][2])) {		// if statement sees if there is a winner diagonally
				if (TicTacToe[2][0] != '\u0000') {
					response = true;
					System.out.println("2");
					if (TicTacToe[2][0] == 'X') {
						statement = "Congrats you won!!4/1";

					} else {
						statement = "Sorry, you lost.4/2";

					}
				}

			}
		int counter = 0;															//loop evaluates if there is a tie
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (TicTacToe[i][j] != '\u0000') {
					counter = 1 + counter;
				}
			}
		}
		if (response == false) {
			if (counter > 8) {
				response = true;
				statement = "It's a tie";
			}
		}
		return response;
	}

	public void AI() {														//AI to put in its entry
		boolean loop = false;
		while (loop == false) {												//exception handling is used to have the AI keep running till it enters a valid entry is found
			try {
				int row = 0 + (int) (Math.random() * 3);
				int col = 0 + (int) (Math.random() * 3);
				char choice = 'O';
				this.Storage(row, col, choice);
				loop = true;
			} catch (IOException exception) {
			} finally {
			}
		}
	}

	public String statement() {												// conclusion Statement is returned

		return statement;
	}
}
