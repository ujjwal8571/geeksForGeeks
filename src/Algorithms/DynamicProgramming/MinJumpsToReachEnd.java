package Algorithms.DynamicProgramming;

import java.util.Scanner;

public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		System.out.println(minJumpsToReachEnd(arr));

		// Scanner scn = new Scanner(System.in);
		//
		// int t = scn.nextInt();
		//
		// while (t-- > 0) {
		//
		// int n = scn.nextInt();
		// int[] arr = new int[n];
		//
		// for (int i = 0; i < n; i++) {
		// arr[i] = scn.nextInt();
		// }
		//
		// System.out.println(minJumpsToReachEnd(arr));
		// }

	}

	public static int minJumpsToReachEnd(int[] arr) {

		int[] strg = new int[arr.length];

		strg[strg.length - 1] = 0;

		for (int i = strg.length - 2; i >= 0; i--) {

			if (arr[i] == 0) {
				strg[i] = Integer.MAX_VALUE;
			}

			else if ((arr[i] - (arr.length - i - 1)) >= 0) {
				strg[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; j < arr.length && j <= arr[i] + i; j++) {
					if (strg[j] < min) {
						min = strg[j];
					}

				}	

				if (min != Integer.MAX_VALUE) {
					strg[i] = min + 1;
				} else {
					
					strg[i] = min;
				}
			}

		}
		
		for(int val:strg) {
			System.out.print(val + "   ");
		}
		System.out.println();

		return strg[0];
	}

}
