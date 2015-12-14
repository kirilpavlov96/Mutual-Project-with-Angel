import java.util.Scanner;

public class knight {
	static void printBoard(char arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "|");
			}
			System.out.println();
		}
	}

	static void printMoves(char arr[][], int row, int col) {
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row + 2 < 8 && col + 1 < 8 && arr[row + 2][col + 1] != '*') {
					arr[row + 2][col + 1] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row + 2 < 8 && col - 1 >= 0 && arr[row + 2][col - 1] != '*') {
					arr[row + 2][col - 1] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row + 1 < 8 && col + 2 < 8 && arr[row + 1][col + 2] != '*') {
					arr[row + 1][col + 2] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row + 1 < 8 && col - 2 >= 0 && arr[row + 1][col - 2] != '*') {
					arr[row + 1][col - 2] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row - 1 >= 0 && col - 2 >= 0 && arr[row - 1][col - 2] != '*') {
					arr[row - 1][col - 2] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row - 1 >= 0 && col + 2 < 8 && arr[row - 1][col + 2] != '*') {
					arr[row - 1][col + 2] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row - 2 >= 0 && col + 1 < 8 && arr[row - 2][col + 1] != '*') {
					arr[row - 2][col + 1] = '*';
				}
			}
		}
		for (int i=0;i<arr.length;i++){
			for (int j = 0; j<arr[0].length; j++) {
				if (row - 2 >= 0 && col - 1 >= 0 && arr[row - 2][col - 1] != '*') {
					arr[row - 2][col - 1] = '*';
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter m");
		int m = sc.nextInt();
		System.out.println("Enter n");
		int n = sc.nextInt();
		char[][] arr = new char[m][n];
		System.out.println("Enter coordinates for row:");
		int row = sc.nextInt();
		System.out.println("Enter coordinates for column:");
		int col = sc.nextInt();
		arr[row][col] = '*';
		
		printBoard(arr);
		printMoves(arr, row, col);
		System.out.println();
		

	}

}
