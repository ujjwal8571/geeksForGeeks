package Algorithms.DynamicProgramming;

public class GoldMineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };

		System.out.println(goldMineProblem(mat));
	}

	public static int goldMineProblem(int[][] mat) {

		int[][] strg = new int[mat.length][mat[0].length];

		for (int i = 0; i < strg.length; i++) {

			strg[i][mat[0].length - 1] = mat[i][mat[0].length - 1];
		}

		for (int j = mat[0].length - 2; j >= 0; j--) {
			for (int i = mat.length - 1; i >= 0; i--) {

				if (i == 0) {

					strg[i][j] = mat[i][j] + Math.max(strg[i][j + 1], strg[i + 1][j + 1]);
				} else if (i == mat.length - 1) {

					strg[i][j] = mat[i][j] + Math.max(strg[i][j + 1], strg[i - 1][j + 1]);
				} else {
					strg[i][j] = mat[i][j] + Math.max(strg[i + 1][j + 1], Math.max(strg[i][j + 1], strg[i - 1][j + 1]));
				}
			}
		}

		int rv = 0;

		for (int i = 0; i < strg.length; i++) {
			if (strg[i][0] > rv) {
				rv = strg[i][0];
			}
		}

		return rv;
	}

}
