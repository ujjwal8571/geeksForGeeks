package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
//		int[] arr = { 50, 3, 10, 7, 40, 80 };
//
//		System.out.println(lis(arr));
//		
		
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		
		while(t-->0) {
			
			int n = scn.nextInt();
			int[] arr = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = scn.nextInt();
			}
			
			System.out.println(lis(arr));
		}

	}

	public static int lis(int[] arr) {

		int[] strg = new int[arr.length];

		Arrays.fill(strg, 1);

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && strg[i] <= strg[j]) {
					strg[i] = strg[j] + 1;
				}
			}
		}

		int rv = 0;

		for (int i = 0; i < strg.length; i++) {
			if (strg[i] > rv) {
				rv = strg[i];
			}
		}

		return rv;

	}

}
