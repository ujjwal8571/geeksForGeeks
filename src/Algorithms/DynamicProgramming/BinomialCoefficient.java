package Algorithms.DynamicProgramming;

public class BinomialCoefficient {

	public static void main(String[] args) {
		System.out.println(binomialCoeffByRecur(3, 2));
		System.out.println(binomialCoeffUsingDp(3, 2));
		System.out.println(binomialCoeffSpaceOpti(3, 2));

	}

	public static int binomialCoeffByRecur(int n, int k) {

		if (n == k || k == 0) {
			return 1;
		}

		return binomialCoeffByRecur(n - 1, k - 1) + binomialCoeffByRecur(n - 1, k);
	}

	public static int binomialCoeffUsingDp(int n, int k) {

		int[][] strg = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {

				if (j > i) {
					continue;
				}

				if (j == 0 || i == j) {
					strg[i][j] = 1;
					continue;
				}

				strg[i][j] = strg[i - 1][j] + strg[i - 1][j - 1];
			}
		}

		return strg[n][k];
	}

	public static int binomialCoeffSpaceOpti(int n, int k) {

		int[] strg = new int[k + 1];

		strg[0] = 1;
		for (int i = 1; i <= n; i++) {

			for (int j = Math.min(i, k); j > 0; j--) {

				strg[j] = strg[j] + strg[j - 1];
			}

		}

		return strg[k];
	}

}
