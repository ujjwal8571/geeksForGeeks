package Algorithms.DynamicProgramming;

public class EndlessPointPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat = { { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 0 } };

		System.out.println(endlessPointPaths2(mat));
	}

	// wrong approach, thinking life mincostpath
	public static int endlessPointPaths(int[][] mat) {

		boolean[][] strg = new boolean[mat.length][mat.length];

		strg[mat.length - 1][mat.length - 1] = mat[mat.length - 1][mat.length - 1] == 1;

		for (int i = mat.length - 2; i >= 0; i--) {

			strg[i][mat.length - 1] = (mat[i][mat.length - 1] == 1 && strg[i + 1][mat.length - 1]);
		}

		for (int i = mat.length - 2; i >= 0; i--) {

			strg[mat.length - 1][i] = (mat[mat.length - 1][i] == 1 && strg[mat.length - 1][i + 1]);
		}

		for (int i = mat.length - 2; i >= 0; i--) {
			for (int j = mat.length - 2; j >= 0; j--) {

				strg[i][j] = mat[i][j] == 1 && strg[i + 1][j] && strg[i][j + 1];
			}
		}

		int rv = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {

				System.out.print(strg[i][j] + "\t");
				if (strg[i][j]) {
					rv++;
				}

			}
			System.out.println();
		}

		return rv;
	}

	// correct approach
	public static int endlessPointPaths2(int[][] mat) {

		int[][] veriStrg = new int[mat.length][mat.length];
		int[][] horiStrg = new int[mat.length][mat.length];

		int len = mat.length;

		for (int i = 0; i < len; i++) {
			veriStrg[len - 1][i] = mat[len - 1][i];
		}

		for (int i = 0; i < len; i++) {
			horiStrg[i][len - 1] = mat[i][len - 1];
		}

		for (int i = len - 2; i >= 0; i--) {

			for (int j = 0; j < len; j++) {

				if (mat[i][j] == 1)
					veriStrg[i][j] = veriStrg[i + 1][j];

			}
		}

		for (int i = len - 1; i >= 0; i--) {

			for (int j = len - 2; j >= 0; j--) {

				if (mat[i][j] == 1)
					horiStrg[i][j] = horiStrg[i][j + 1];

			}
		}

		int rv = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (veriStrg[i][j] == 1 && horiStrg[i][j] == 1) {
					rv++;
				}
			}
		}

		return rv;

	}
}
