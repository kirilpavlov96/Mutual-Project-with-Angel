import java.util.Scanner;

public class ms {
	static boolean vic;
	static char arr[][] = { { ' ', ' ', ' ' },
							{ ' ', ' ', ' ' }, 
							{ ' ', ' ', ' ' } };
	
	 static void ifWon() {
		boolean ifWonState = false;
		if ((arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]) && (arr[0][0]=='x'||arr[0][0]=='o')) {
			ifWonState = true;
		}
		
		if ((arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]) && (arr[1][1]=='x'||arr[1][1]=='o')) {
			ifWonState = true;
		}
		if ((arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]) && (arr[2][1]=='x'||arr[2][1]=='o')) {
			ifWonState = true;
		}
		if ((arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) && (arr[1][0]=='x'||arr[1][0]=='o')) {
			ifWonState = true;
		}
		if ((arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]) && (arr[1][1]=='x'||arr[1][1]=='o')) {
			ifWonState = true;
		}
		if ((arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]) && (arr[1][2]=='x'||arr[1][2]=='o')) {
			ifWonState = true;
		}
		if ((arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) && (arr[1][1]=='x'||arr[1][1]=='o')) {
			ifWonState = true;
		}
		if ((arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) && (arr[1][1]=='x'||arr[1][1]=='o')) {
			ifWonState = true;
		}
		if (ifWonState == true) {
			System.out.println("Winner!");
			vic = true;
		}
	}

	static void printBoard(char arr[][]) {
		for (int i = 0; i <arr.length; i++) {
			for (int j = 0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vic = false;
		int turn;
		char fill;
				
			for (turn = 1; turn <= 9; turn++) {
				printBoard(arr);
				if (turn % 2 == 0) {
					fill = 'o';
				} else {
					fill = 'x';
				}
				System.out.println("Type coordinates for row (0-2):");
				int n = sc.nextInt();
				System.out.println("Type coordinates for column (0-2):");
				int m = sc.nextInt();
				if (n>2||n<0||m>2||m<0){
					System.out.println("Invalid coordinates!");
					break;
				}
				if (arr[n][m]==' ') {
					arr[n][m] = fill;
				}
				else {
					System.out.println("Invalid coordinates!");
					break;
				}
					ifWon();
					if (vic == true){break;}
			}
	}
}
