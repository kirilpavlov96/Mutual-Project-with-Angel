import java.util.Scanner;

public class TicTacToe {
	private boolean victory;
	private char arr[][];

	public TicTacToe() {
		this.arr=new char[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				arr[i][j]=' ';
	}
	private char ifWon() {
		boolean ifWonState = false;
		char c='1';
		if ((arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]) && (arr[0][0] == 'X' || arr[0][0] == 'O')) {
			ifWonState = true;
			c=arr[0][0];
		}

		if ((arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]) && (arr[1][1] == 'X' || arr[1][1] == 'O')) {
			ifWonState = true;
			c=arr[1][1];
		}
		if ((arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]) && (arr[2][1] == 'X' || arr[2][1] == 'O')) {
			ifWonState = true;
			c=arr[2][1];
		}
		if ((arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) && (arr[1][0] == 'X' || arr[1][0] == 'O')) {
			ifWonState = true;
			c=arr[1][0];
		}
		if ((arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]) && (arr[1][1] == 'X' || arr[1][1] == 'O')) {
			ifWonState = true;
			c=arr[1][1];
		}
		if ((arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]) && (arr[1][2] == 'X' || arr[1][2] == 'O')) {
			ifWonState = true;
			c=arr[1][2];
		}
		if ((arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) && (arr[1][1] == 'X' || arr[1][1] == 'O')) {
			ifWonState = true;
			c=arr[1][1];
		}
		if ((arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) && (arr[1][1] == 'X' || arr[1][1] == 'O')) {
			ifWonState = true;
			c=arr[1][1];
		}
		if (ifWonState == true) {
			System.out.println("Winner!");
			victory = true;
		}
		return c;
	}

	private void printBoard(char arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "|");
			}
			System.out.println();
		}
	}
	
	public void play(){
		Scanner sc = new Scanner(System.in);
		victory = false;
		int turn=1;
		char fill;
			while(turn<=9) {
				printBoard(arr);
				if (turn % 2 == 0) {
					fill = 'O';
				} else {
					fill = 'X';
				}
				System.out.print("Type coordinates for row (1-3):");
				int n = sc.nextInt();
				System.out.print("Type coordinates for column (1-3):");
				int m = sc.nextInt();
				if (n>3||n<1||m>3||m<1){
					System.out.println("Invalid coordinates!Try again.");
					continue;
				}
				if (arr[n-1][m-1]==' ') {
					arr[n-1][m-1] = fill;
				}
				else {
					System.out.println("Invalid coordinates!Try again.");
					continue;
				}
					char c=ifWon();
					if (victory == true)
					{
						System.out.println("Player \""+c+"\" wins.");
						break;
					}
					turn++;
			}
	}
}
