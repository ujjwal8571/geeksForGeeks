package AllHashOps;

import java.util.HashMap;
import java.util.Scanner;

public class DivideArrayToFormDivPair {

	public static void main(String[] args) {

		// int arr[] = { 92, 75, 65, 48, 45, 35 };
		// int k = 19;
		//
		// System.out.println(canDivisiblePairsBeFormed(arr, k));

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {

			int r = scn.nextInt();
			int[] arr = new int[r];

			for (int i = 0; i < arr.length; i++) {

				arr[i] = scn.nextInt();
			}
			int k = scn.nextInt();

			if (canDivisiblePairsBeFormed(arr, k)) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}

			t--;
		}
	}

	public static boolean canDivisiblePairsBeFormed(int[] arr, int k) {

		boolean rv = true;

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int rem = arr[i] % k;

			if (!hm.containsKey(rem)) {
				hm.put(rem, 0);
			}
			hm.put(rem, hm.get(rem) + 1);
		}

		for (int val : arr) {
			int rem = val % k;

			if (2 * rem == k) { // remainder divides k into 2 equal halves

				if (hm.get(rem) % 2 != 0) {
					return false;
				}
			}

			else if (rem == 0) { // number is completely divisible by k

				if (hm.get(rem) % 2 != 0) {
					return false;
				}
			}

			else { // any other remainder
				if (hm.get(k - rem) != hm.get(rem)) {
					return false;
				}
			}
		}

		return rv;
	}

}
