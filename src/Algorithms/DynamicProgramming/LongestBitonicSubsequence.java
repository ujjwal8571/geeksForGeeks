package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 80, 60, 30, 40, 20, 10 };

		System.out.println(longestBitonicSs(arr));
	}

	public static int longestBitonicSs(int[] arr) {

		int[] lis = new int[arr.length];
		int[] lds = new int[arr.length];

		Arrays.fill(lis, 1);
		Arrays.fill(lds, 1);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && lis[i] <= lis[j]) {
					lis[i] = lis[j] + 1;
				}

				if (arr[i] < arr[j] && lds[i] <= lds[j]) {
					lds[i] = lds[j] + 1;
				}
			}
		}

		int rv = 0;
		for (int i = 0; i < lis.length; i++) {

			int temp = lis[i] + lds[i] - 1;

			if (temp > rv) {
				rv = temp;
			}

		}

		return rv;
	}

}
