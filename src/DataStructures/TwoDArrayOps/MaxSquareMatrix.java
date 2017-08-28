package TwoDArrayOps;

public class MaxSquareMatrix {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		maxSquare(arr);

	}

	public static void maxSquare(int[][] arr) {
		int[][] strg = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr[0].length; i++) {
			strg[strg.length - 1][i] = arr[arr.length - 1][i];

		}

		for (int i = 0; i < arr.length; i++) {
			strg[i][strg[0].length - 1] = arr[i][arr[0].length - 1];

		}

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr[0].length - 2; j >= 0; j--) {
				if (arr[i][j] == 1) {
					int temp = Math.min(strg[i + 1][j], Math.min(strg[i][j + 1], strg[i + 1][j + 1]));
					strg[i][j] = temp + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (strg[i][j] > max) {
					max = strg[i][j];
				}

			}

		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				System.out.print("1 ");
			}
			System.out.println();
		}

	}

	public static void display(int[][] arr) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
