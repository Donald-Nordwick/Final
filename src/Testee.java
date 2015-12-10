
public class Testee {
	static void main(String[] Args){
	int[][] TicTacToe = new int[3][3];
	for (int i = 0; i <3; i++){
		for (int j = 0; j <3; j++){
			TicTacToe[j][i]=j;
		}
	}

	System.out.printf("___________\n");
	for(int i = 0; i<3;i++){
		System.out.printf(" %c | %c | %c \n", TicTacToe[i][0],TicTacToe[i][1],TicTacToe[i][2]);
		System.out.printf("___________\n");
	}
	}
}
