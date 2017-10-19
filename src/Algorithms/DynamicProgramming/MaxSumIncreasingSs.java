package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaxSumIncreasingSs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] arr = {10, 5, 4, 3};
		 System.out.println(maxSumIncreasingSs(arr));

	}

	public static int maxSumIncreasingSs(int[] arr) {

		int[] strg = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			int tempVal = arr[i];
			strg[i] = tempVal;
			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i] && strg[j] + tempVal >= strg[i]) {
					strg[i] = strg[j] + tempVal;
				}

			}
		}

		int rv = 0;
		for (int val : strg) {

			if (val > rv) {
				rv = val;
			}
		}

		return rv;
	}

}
