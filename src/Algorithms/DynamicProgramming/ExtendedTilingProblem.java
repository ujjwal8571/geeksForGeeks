package Algorithms.DynamicProgramming;

import java.util.Scanner;

public class ExtendedTilingProblem {
	public static void main(String[] args) {

		// System.out.println(extendedTilingProb(5));

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {
			int n = scn.nextInt();

			System.out.println(extendedTilingProb(n));
		}
	}

	public static int extendedTilingProb(int n) {
		int[] strg = new int[n + 1];

		if (n < 4) {
			return 1;
		}

		strg[0] = strg[1] = strg[2] = strg[3] = 1;

		for (int i = 4; i < strg.length; i++) {

			strg[i] = strg[i - 1] + strg[i - 4];
		}

		return strg[n];
	}
}
