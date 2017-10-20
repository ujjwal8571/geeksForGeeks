package Algorithms.DynamicProgramming;

public class CountWayToReachBottom {

	public static void main(String[] args) {
		System.out.println(countWaysToReachBottom(3, 3));

	}

	public static int countWaysToReachBottom(int r, int c) {
		int[][] strg = new int[r][c];

		for (int i = 0; i < strg.length; i++) {
			strg[i][strg[0].length - 1] = 1;
		}

		for (int i = 0; i < strg[0].length; i++) {
			strg[strg.length - 1][i] = 1;
		}

		for (int i = strg.length - 2; i >= 0; i--) {
			for (int j = strg[0].length - 2; j >= 0; j--) {

				strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
			}
		}

		return strg[0][0];
	}

}
