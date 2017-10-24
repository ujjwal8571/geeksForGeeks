package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaxSumPairSpecDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3, 5, 10, 15, 17, 12, 9};
		
		System.out.println(maxSumpairSpecDiff(arr, 4	));
	}

	public static int maxSumpairSpecDiff(int[] arr, int k) {

		Arrays.sort(arr);

		int[] strg = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {

			strg[i] = strg[i - 1]; // case in which it is excluded as it does not make a pair

			if (arr[i] - arr[i - 1] < k) {

				if (i >= 2) {

					strg[i] = Math.max(strg[i], strg[i - 2] + arr[i] + arr[i - 1]);
				} else {
					strg[i] = Math.max(strg[i], arr[i] + arr[i - 1]);
				}
			}
		}
		
		for(int i=0;i<strg.length;i++) {
			System.out.print(strg[i] + ", ");
		}
		System.out.println();

		return strg[strg.length - 1];
	}
}
