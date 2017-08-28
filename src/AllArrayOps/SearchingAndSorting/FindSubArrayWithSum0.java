package AllArrayOps.SearchingAndSorting;

import java.util.HashMap;
import java.util.Scanner;

public class FindSubArrayWithSum0 {

	public static void main(String[] args) {
		int[] arr = { 36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9 };
		System.out.println(isSSPresent(arr));

		// Scanner scn = new Scanner(System.in);
		// int t = scn.nextInt();
		//
		// while (t > 0) {
		//
		// int n = scn.nextInt();
		//
		// int[] arr = new int[n];
		//
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = scn.nextInt();
		// }
		//
		// if (isSSpresentWithSum0(arr)) {
		// System.out.println("Yes");
		// } else {
		// System.out.println("No");
		// }
		//
		// t--;
		// }
	}

	// INCORRECT
	public static boolean isSSpresentWithSum0(int[] arr) {

		int sumSoFar = arr[0];

		if (sumSoFar == 0) {
			return true;
		}
		System.out.println(arr[0] + " => " + sumSoFar);

		for (int i = 1; i < arr.length; i++) {

			int tempSum = sumSoFar + arr[i];

			if ((sumSoFar >= 0 && tempSum < sumSoFar) || sumSoFar <= 0 && tempSum > sumSoFar) {
				sumSoFar = tempSum;
			} else {
				sumSoFar = arr[i];
			}
			System.out.println(arr[i] + " => " + sumSoFar);
			if (sumSoFar == 0) {
				return true;
			}
		}
		return false;

	}

	// CORRECT METHOD
	public static boolean isSSPresent(int[] arr) {
		HashMap<Integer, Boolean> hm = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];

			sum += val;

			if (arr[i] == 0 || sum == 0 || hm.containsKey(sum)) {
				return true;
			}

			hm.put(sum, true);
		}

		return false;

	}

}
