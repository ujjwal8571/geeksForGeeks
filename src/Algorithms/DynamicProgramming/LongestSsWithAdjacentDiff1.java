package Algorithms.DynamicProgramming;

public class LongestSsWithAdjacentDiff1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 3, 2, 3, 7, 2, 1};
		System.out.println(longestSsWithAdjacentDiff1(arr));
	}

	public static int longestSsWithAdjacentDiff1(int[] arr) {
		int[] strg = new int[arr.length];

		for (int i = 1; i < strg.length; i++) {

			strg[i] = strg[i - 1];
			if (Math.abs(arr[i] - arr[i - 1]) == 1) {

				strg[i]++;
			}
		}

		return strg[strg.length - 1];
	}

}
