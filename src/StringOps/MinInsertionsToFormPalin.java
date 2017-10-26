package StringOps;

import Algorithms.DynamicProgramming.LongestCommonSubsequence;

public class MinInsertionsToFormPalin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(minInsertionsToFormPalinRecur("geeks"));
		System.out.println(minInsertionsToFormPalinLCS("geeks"));

		String temp = "abcd";
		// System.out.println(temp.substring(0, temp.length() - 1));
		System.out.println(temp.substring(0, temp.length() - 1) + ", " + temp.substring(1));
	}

	// incorrect solution
	public static int minInsertionsToFormPalin(String str) {

		int i = 0;
		int j = str.length() - 1;

		int rv = 0;
		while (i <= j) {

			char ithChar = str.charAt(i);
			char jthChar = str.charAt(j);

			if (ithChar == jthChar) {
				i++;
				j--;
			} else {
				rv++;
				j--;
			}
		}

		return rv;
	}

	public static int minInsertionsToFormPalinRecur(String str) {

		if (str.length() == 0) {
			return Integer.MAX_VALUE;
		}

		if (str.length() == 1) {
			return 0;
		}

		if (str.length() == 2) {

			return (str.charAt(0) == str.charAt(1)) ? 0 : 1;
		}

		if (str.charAt(0) == str.charAt(str.length() - 1)) {

			return minInsertionsToFormPalinRecur(str.substring(1, str.length() - 1));
		} else {

			int lAns = minInsertionsToFormPalinRecur(str.substring(1));
			int rAns = minInsertionsToFormPalinRecur(str.substring(0, str.length() - 1));

			return Math.min(lAns, rAns) + 1;
		}

	}

	public static int minInsertionsToFormPalinLCS(String str) {

		String rev = new StringBuilder(str).reverse().toString();

		return str.length() - LongestCommonSubsequence.countLcsLengthDp(str, rev);

	}

}
