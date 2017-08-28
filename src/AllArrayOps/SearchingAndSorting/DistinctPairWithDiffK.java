package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class DistinctPairWithDiffK {

	public static void main(String[] args) {
		int[] arr = {8, 12, 16, 4, 0, 20};
		System.out.println(pairWithDiffK(arr, 0));
	}
	
	// problem in method 5
	
	// can be done in o(n) using hashing with o(n) extra space of hashmap

	public static int pairWithDiffK(int[] arr, int k) {

		if (k == 0) {
			return arr.length;
		}

		Arrays.sort(arr);
		int count = 0;

		for (int i = arr.length - 1; i > 0; i--) {

			int data = arr[i] - k;

			if (binarySearch(arr, 0, i - 1, data)) {
				count++;
			}

		}

		return count;

	}

	public static boolean binarySearch(int[] arr, int low, int high, int data) {

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] == data) {
				return true;
			} else if (arr[mid] < data) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return false;
	}

}
