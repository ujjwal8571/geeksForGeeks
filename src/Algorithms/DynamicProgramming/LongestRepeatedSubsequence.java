package Algorithms.DynamicProgramming;

public class LongestRepeatedSubsequence {

	public static void main(String[] args) {
		String str = "AABEBCDD";

		System.out.println(countLengthofLrs(str));
		System.out.println(printLengthofLrs(str));

	}

	public static int countLengthofLrs(String str) {

		int[][] strg = new int[str.length() + 1][str.length() + 1];

		for (int i = str.length() - 1; i >= 0; i--) {

			char ch1 = str.charAt(i);

			for (int j = str.length() - 1; j >= 0; j--) {
				char ch2 = str.charAt(j);

				if (ch1 == ch2 && i != j) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}

			}
		}

		return strg[0][0];

	}

	public static String printLengthofLrs(String str) {

		String ans = "";
		int[][] strg = new int[str.length() + 1][str.length() + 1];

		for (int i = str.length() - 1; i >= 0; i--) {

			char ch1 = str.charAt(i);

			for (int j = str.length() - 1; j >= 0; j--) {
				char ch2 = str.charAt(j);

				if (ch1 == ch2 && i != j) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}

				if (strg[i][j] > Math.max(strg[i + 1][j], strg[i][j + 1])) {
					ans += ch1;
				}

			}
		}

		return new StringBuilder(ans).reverse().toString();

	}

}
