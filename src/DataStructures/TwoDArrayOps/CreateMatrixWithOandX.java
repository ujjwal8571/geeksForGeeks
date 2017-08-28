package TwoDArrayOps;

public class CreateMatrixWithOandX {

	public static void main(String[] args) {

		int m = 6, n = 7;
		display(createMatrixWithOnX(m, n));

	}

	public static char[][] createMatrixWithOnX(int rows, int cols) {
		char[][] arr = new char[rows][cols];

		int leftCol = 0;
		int rightCol = cols - 1;
		int topRow = 0;
		int bottomRow = rows - 1;
		boolean isX = true;

		while (leftCol <= rightCol && topRow <= bottomRow) {

			// for top row
			for (int i = leftCol; i <= rightCol; i++) {
				if (isX) {
					arr[topRow][i] = 'X';
				} else {
					arr[topRow][i] = 'O';

				}

			}
			topRow++;

			// for bottom row
			for (int i = leftCol; i <= rightCol; i++) {

				if (isX) {
					arr[bottomRow][i] = 'X';
				} else {
					arr[bottomRow][i] = 'O';

				}

			}
			bottomRow--;

			// for left col
			for (int i = topRow; i <= bottomRow; i++) {
				if (isX) {
					arr[i][leftCol] = 'X';
				} else {
					arr[i][leftCol] = 'O';

				}

			}
			leftCol++;

			// for bottom col
			for (int i = topRow; i <= bottomRow; i++) {
				if (isX) {
					arr[i][rightCol] = 'X';
				} else {
					arr[i][rightCol] = 'O';

				}

			}
			rightCol--;

			isX = !isX;
		}

		return arr;

	}

	public static void display(char[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + ",");
			}
			System.out.println();
		}
	}
}
