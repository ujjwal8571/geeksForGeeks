package Algorithms.DynamicProgramming;

public class MaxPathAvgValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 2, 3 }, { 6, 5, 4 }, { 7, 3, 9 } };

		System.out.println(maxPathAvgSum(mat));
	}

	public static double maxPathAvgSum(int[][] mat) {
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

				strg[i][j] = mat[i][j] + Math.max(strg[i + 1][j], strg[i][j + 1]);
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(strg[i][j] + "\t");
			}
			System.out.println();
		}
		double ans = (double) strg[0][0] / (2 * mat.length - 1);

		return ans;
	}

}
