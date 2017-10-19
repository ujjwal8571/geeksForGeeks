package Algorithms.DynamicProgramming;

import java.util.Scanner;

public class MinCostPath {

	public static void main(String[] args) {
		// int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		//
		// System.out.println(minCostPath(cost));

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {

			int n = scn.nextInt();
			int[][] mat = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = scn.nextInt();
				}
			}

			System.out.println(maxPathInMatrix(mat));
		}
	}

	public static int minCostPath(int[][] mat) {

		int[][] strg = new int[mat.length][mat[0].length];

		int tempSum = 0;
		for (int i = mat.length - 1; i >= 0; i--) {
			tempSum += mat[i][mat[0].length - 1];

			strg[i][mat[0].length - 1] = tempSum;
		}

		tempSum = 0;

		for (int i = mat[0].length - 1; i >= 0; i--) {
			tempSum += mat[mat.length - 1][i];
			strg[mat.length - 1][i] = tempSum;
		}

		for (int i = mat.length - 2; i >= 0; i--) {
			for (int j = mat[0].length - 2; j >= 0; j--) {

				strg[i][j] = mat[i][j] + Math.min(strg[i + 1][j + 1], Math.min(strg[i + 1][j], strg[i][j + 1]));
			}
		}

		return strg[0][0];

	}

	public static int maxPathInMatrix(int[][] mat) {

		int[][] strg = new int[mat.length][mat[0].length];

		int tempSum = 0;
		for (int i = mat.length - 1; i >= 0; i--) {
			tempSum += mat[i][mat[0].length - 1];

			strg[i][mat[0].length - 1] = tempSum;
		}

		tempSum = 0;

		for (int i = mat[0].length - 1; i >= 0; i--) {
			tempSum += mat[mat.length - 1][i];
			strg[mat.length - 1][i] = tempSum;
		}

		for (int i = mat.length - 2; i >= 0; i--) {
			for (int j = mat[0].length - 2; j >= 0; j--) {

				strg[i][j] = mat[i][j] + Math.max(strg[i + 1][j + 1], Math.max(strg[i + 1][j], strg[i][j + 1]));
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
