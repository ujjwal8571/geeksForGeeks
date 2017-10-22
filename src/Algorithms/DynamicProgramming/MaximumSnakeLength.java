package Algorithms.DynamicProgramming;

public class MaximumSnakeLength {

	public static void main(String[] args) {
		int[][] mat = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }, };

		System.out.println(maximumSnakeLength(mat));

	}

	public static int maximumSnakeLength(int[][] mat) {
		int[][] strg = new int[mat.length][mat[0].length];

		for (int i = strg.length - 1; i >= 0; i--) {
			for (int j = strg[0].length - 1; j >= 0; j--) {

				int max = 1;

				if (i < strg.length - 1 && Math.abs(mat[i + 1][j] - mat[i][j]) == 1) {
					int temp = strg[i + 1][j] + 1;

					if (temp > max) {
						max = temp;
					}

				}

				if (j < strg[0].length - 1 && Math.abs(mat[i][j + 1] - mat[i][j]) == 1) {
					int temp = strg[i][j + 1] + 1;

					if (temp > max) {
						max = temp;
					}
				}

				strg[i][j] = max;
			}
		}

		int rv = 0;
		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j < strg[0].length; j++) {

				if (strg[i][j] > rv) {

					rv = strg[i][j];
				}
			}
		}

		return rv;
	}

}
