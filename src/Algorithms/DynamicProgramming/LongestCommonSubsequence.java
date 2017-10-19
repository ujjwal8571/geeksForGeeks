package Algorithms.DynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String one = "cce";
		String two = "cccce";

		lcsAns la = new lcsAns();
		printLcs(one, two, "", la);

		System.out.println(la.ans);

		System.out.println(countLcsLengthDp(one, two));
		System.out.println(printLcsLengthDp(one, two));
	}

	public static class lcsAns { // just to store the final ans
		int maxLen = 0;
		String ans = "";
	}

	public static void printLcs(String one, String two, String ans, lcsAns la) {

		if (one.length() == 0 || two.length() == 0) {
			if (ans.length() > la.maxLen) {
				la.maxLen = ans.length();
				la.ans = ans;

			}
			return;
		}

		char oneCh = one.charAt(0);
		char twoCh = two.charAt(0);

		String oneRs = one.substring(1);
		String twoRs = two.substring(1);

		if (oneCh == twoCh) {
			printLcs(oneRs, twoRs, ans + oneCh, la);
		} else {
			printLcs(oneRs, two, ans, la);
			printLcs(one, twoRs, ans, la);
			printLcs(oneRs, twoRs, ans, la);
		}

	}

	public static int countLcsLengthDp(String one, String two) {

		int[][] strg = new int[one.length() + 1][two.length() + 1];

		for (int i = one.length() - 1; i >= 0; i--) {
			char oneCh = one.charAt(i);

			for (int j = two.length() - 1; j >= 0; j--) {
				char twoCh = two.charAt(j);

				if (oneCh == twoCh) {

					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {

					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}
			}
		}

		return strg[0][0];
	}

	public static String printLcsLengthDp(String one, String two) {

		String str = "";

		int[][] strg = new int[one.length() + 1][two.length() + 1];

		for (int i = one.length() - 1; i >= 0; i--) {
			char oneCh = one.charAt(i);

			for (int j = two.length() - 1; j >= 0; j--) {
				char twoCh = two.charAt(j);

				if (oneCh == twoCh) {

					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {

					strg[i][j] = Math.max(strg[i + 1][j], strg[i][j + 1]);
				}

				if (strg[i][j] > Math.max(strg[i + 1][j], strg[i][j + 1])) {
					str += oneCh;
				}
			}
		}

		return new StringBuilder(str).reverse().toString();
	}
}
