package Algorithms.DynamicProgramming;

public class MaxSizeSqSubMatrix {

	public static void main(String[] args) {
		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		System.out.println(maxSizeSqSubMatrix(M));

	}

	public static int maxSizeSqSubMatrix(int[][] mat) {

		int[][] strg = new int[mat.length][mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			strg[i][0] = mat[i][0];
		}

		for (int i = 0; i < mat[0].length; i++) {
			strg[0][i] = mat[0][i];
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {

				if (mat[i][j] == 1) {
					strg[i][j] = Math.min(strg[i - 1][j - 1], Math.min(strg[i][j - 1], strg[i - 1][j])) + 1;
				}
			}
		}

		int rv = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (strg[i][j] > rv) {
					rv = strg[i][j];
				}
			}
		}

		return rv;

	}

}
