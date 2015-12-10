import java.io.IOException;
import java.util.NoSuchElementException;

public class Memory {
	private char[][] TicTacToe = new char[3][3];

	private String statement;

	public Memory() {

	}

	public void Storage(int Row, int Col, char input) throws IOException {
		try {
			if ((Row < 0) || (Row > 2) || (Col < 0) || (Col > 2)) {
				throw new NoSuchElementException();
			}
			if (TicTacToe[Row][Col] != '\u0000') {
				throw new IOException();
			} else {
				TicTacToe[Row][Col] = input;
			}
		} finally {
		}

	}

	public void gameBoard() {
		System.out.printf("___________\n");
		for (int i = 0; i < 3; i++) {
			System.out.printf(" %c | %c | %c \n", TicTacToe[i][0], TicTacToe[i][1], TicTacToe[i][2]);
			System.out.printf("___________\n");
		}
	}

	public boolean referee() {
		boolean response = false;
		for (int i = 0; i < 3; i++) {
			if ((TicTacToe[i][0] == TicTacToe[i][1]) && (TicTacToe[i][1] == TicTacToe[i][2])) {
				if (TicTacToe[i][0] != '\u0000') {
					response = true;
					if (TicTacToe[i][0] == 'X') {
						statement = "Congrats you won!!1part1";
						break;
					} else {
						statement = "Sorry, you lost.1part2";
						break;
					}
				}
			} else if ((TicTacToe[0][i] == TicTacToe[1][i]) && (TicTacToe[1][i] == TicTacToe[2][i])) {
				if (TicTacToe[0][i] != '\u0000') {
					response = true;

					if (TicTacToe[0][i] == 'X') {
						statement = "Congrats you won!!";
						break;
					} else {
						statement = "Sorry, you lost.";
						break;
					}
				}
			}

		}

		if ((TicTacToe[0][0] == TicTacToe[1][1]) && (TicTacToe[1][1] == TicTacToe[2][2])) {
			if (TicTacToe[0][0] != '\u0000') {
				response = true;
				System.out.println("1");
				if (TicTacToe[0][0] == 'X') {
					statement = "Congrats you won!!";
				} else {
					statement = "Sorry, you lost.";
				}
			}
		}else if ((TicTacToe[2][0] == TicTacToe[1][1]) || (TicTacToe[1][1] == TicTacToe[0][2])) {
				if (TicTacToe[2][0] != '\u0000') {
					response = true;
					System.out.println("2");
					if (TicTacToe[2][0] == 'X') {
						statement = "Congrats you won!!";

					} else {
						statement = "Sorry, you lost.";

					}
				}

			}
		int counter = 0;
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

	public void AI() {
		boolean loop = false;
		while (loop == false) {
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

	public String statement() {

		return statement;
	}
}
