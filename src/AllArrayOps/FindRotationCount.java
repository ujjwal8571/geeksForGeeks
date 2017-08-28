package AllArrayOps;

import java.util.Scanner;

public class FindRotationCount {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 1, 2 };
//		System.out.println(findRotationCount(arr));
		System.out.println(pivotOfRotatedArray(arr));

		// Scanner scn = new Scanner(System.in);
		//
		// int t = scn.nextInt();
		// while (t > 0) {
		// int n = scn.nextInt();
		//
		// int[] arr = new int[n];
		//
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = scn.nextInt();
		// }
		// System.out.println(findRotationCount(arr));
		// t--;
		// }
	}

	public static int findRotationCount(int[] arr) {
		int rots = pivotOfRotatedArray(arr);

		if (rots > -1) {
			return rots + 1;
		} else {
			return 0;
		}
	}

	public static int pivotOfRotatedArray(int[] arr) {
		int low = 0, high = arr.length - 1;

		while (low < high) {

			int mid = (low + high) / 2;

			if (mid < high && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (mid > low && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			} else if (arr[mid] >= arr[low]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

}
