package AllLinkedListOps;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tempClass {

	public static void main(String[] args) throws java.lang.Exception {

		int[] arr = { 1, 4, 5, 7, 15, 17, 21, 23, 27, 40, 44, 55 };
		printClosest5(arr, 32);

	}

	public static int find(ArrayList<Integer> list, int val) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == val) {
				return i;
			}
		}

		return -1;
	}

	public static void printClosest5(int[] arr, int val) {

		pair[] p = new pair[arr.length];

		for (int i = 0; i < arr.length; i++) {

			p[i] = new pair(Math.abs(val - arr[i]), arr[i]);
		}

		Arrays.sort(p);
		int[] rv = new int[5];
		for (int i = 0; i < 5; i++) {
			rv[i] = p[i].num;
		}
		
		Arrays.sort(rv);
		
		for(int n:rv) {
			System.out.println(n);
		}

	}

	public static class pair implements Comparable<pair> {
		int num;
		int diff;

		public pair(int diff, int num) {
			this.num = num;
			this.diff = diff;
		}

		@Override
		public int compareTo(pair o) {
			return this.diff - o.diff;
		}

	}
}
