package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSumProblem {

	public static void main(String[] args) {
		 int[] set = { 3, 34, 4, 12, 5, 2 };
		 int sum = 12;
		
		 System.out.println(subsetSumProblem(set, sum));
		 
		

	}

	public static boolean subsetSumProblem(int[] arr, int sum) {

		boolean[][] strg = new boolean[arr.length][sum + 1];
		Arrays.sort(arr);

		for (int i = 0; i < strg.length; i++) {
			strg[i][0] = true;
		}

		for (int i = 0; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {

				if (j == arr[i]) {
					strg[i][j] = true;
					continue;
				}

				if (i > 0 && strg[i - 1][j] == true) {
					strg[i][j] = true;
					continue;
				}

				if (j - arr[i] < 0) {
					strg[i][j] = false;
					continue;
				}

				if (i > 0) {

					strg[i][j] = strg[i - 1][j - arr[i]];
				}
			}
		}

		// for (int i = 0; i < strg.length; i++) {
		// for (int j = 0; j < strg[0].length; j++) {
		//
		// System.out.print(strg[i][j] + " ");
		// }
		// System.out.println();
		// }

		return strg[strg.length - 1][strg[0].length - 1];
	}
}
