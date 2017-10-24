package Algorithms.DynamicProgramming;

public class MaxWeightPathTillLastRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 4, 1, 5, 6, 1 }, { 2, 9, 2, 11, 10 }, { 15, 1, 3, 15, 2 }, { 16, 92, 41, 4, 3 },
				{ 8, 142, 6, 4, 8 } };

		System.out.println(maxWeightPathTillEndRow(mat));

	}

	public static int maxWeightPathTillEndRow(int[][] mat) {

		for (int i = mat.length - 2; i >= 0; i--) {

			mat[i][mat[0].length - 1] += mat[i + 1][mat[0].length - 1];
		}

		for (int i = mat.length - 2; i >= 0; i--) {
			for (int j = mat[0].length - 2; j >= 0; j--) {

				mat[i][j] += Math.max(mat[i + 1][j + 1], mat[i + 1][j]);
			}
		}

		return mat[0][0];
	}
}
