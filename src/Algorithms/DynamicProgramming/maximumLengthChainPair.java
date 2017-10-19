package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class maximumLengthChainPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// pair[] arr = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} };
		// pair[] arr = new pair[5];
		//
		// arr[0] = new pair(5, 24);
		// arr[1] = new pair(39, 64);
		// arr[2] = new pair(15, 28);
		// arr[3] = new pair(27, 40);
		// arr[4] = new pair(50, 90);

//		System.out.println(maxLengthChainPair(arr));

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t-- > 0) {

			int n = scn.nextInt();
			pair[] arr = new pair[n];
			for (int i = 0; i < n; i++) {
				int one = scn.nextInt();
				int two = scn.nextInt();
				
				arr[i] = new pair(one, two);
			}
			
			System.out.println(maxLengthChainPair(arr));

		}

	}

	public static class pair implements Comparable<pair>{
		int one;
		int two;

		public pair(int one, int two) {
			this.one = one;
			this.two = two;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.one - o.one;
		}
	}
	 

	public static int maxLengthChainPair(pair[] arr) {

		int[] strg = new int[arr.length];
		Arrays.fill(strg, 1);

		for (int i = 0; i < arr.length; i++) {
			pair currPair = arr[i];

			for (int j = 0; j < i; j++) {
				pair prevPair = arr[j];

				if (currPair.one > prevPair.two && strg[j] <= strg[i]) {
					strg[i] = strg[j] + 1;
				}

			}
		}

		int rv = 0;
		for (int val : strg) {
			System.out.println(val);
			if (val > rv) {
				rv = val;
			}
		}

		return rv;
	}

}
