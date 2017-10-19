package Algorithms.DynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(editDistance("sunday", "saturday"));

	}

	public static int editDistance(String one, String two) {
		int[][] strg = new int[one.length() + 1][two.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			strg[i][strg[0].length - 1] = strg.length - 1 - i;
		}

		for (int i = 0; i < strg[0].length; i++) {
			strg[strg.length - 1][i] = strg[0].length - 1 - i;
		}

		for (int i = strg.length - 2; i >= 0; i--) {
			for (int j = strg[0].length - 2; j >= 0; j--) {

				if (one.charAt(i) == two.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1];
				} else {
					strg[i][j] = 1 + Math.min(strg[i + 1][j + 1], Math.min(strg[i + 1][j], strg[i][j + 1]));
				}

			}
		}

		return strg[0][0];

	}
}
