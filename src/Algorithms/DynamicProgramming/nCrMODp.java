package Algorithms.DynamicProgramming;

public class nCrMODp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int nCrModP(int n, int r, int p) {

		int[][] strg = new int[n + 1][r + 1];

		strg[0][0] = 1;
		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j <= r; j++) {

				if (j > i) {

					continue;
				}

				if (j == 0 || i == j) {
					strg[i][j] = 1;
					continue;
				}

				strg[i][j] = (strg[i - 1][j - 1] + strg[i][j - 1]) % p;
			}
		}

		return strg[n][n];
	}
}
