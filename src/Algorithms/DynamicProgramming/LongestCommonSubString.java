package Algorithms.DynamicProgramming;

public class LongestCommonSubString {

	public static void main(String[] args) {

		String one = "zxabcdezy";
		String two = "yzabcdezx";
		System.out.println(longestCommonSubString(one, two));

	}

	public static int longestCommonSubString(String one, String two) {

		int[][] strg = new int[one.length() + 1][two.length() + 1];

		for (int i = strg.length - 2; i >= 0; i--) {

			for (int j = strg[0].length - 2; j >= 0; j--) {

				if (one.charAt(i) == two.charAt(j)) {

					strg[i][j] = strg[i + 1][j + 1] + 1;

				}
			}
		}

		int rv = 0;
		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < strg[0].length; j++) {
				if (strg[i][j] > rv) {
					rv = strg[i][j];
				}
			}

		}

		return rv;
	}

}
