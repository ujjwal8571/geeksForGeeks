package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class TripletSumSmallerThanGivenValue {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 3, 4, 7 };
		System.out.println(countTriplets(arr, 12));

	}

	public static int countTriplets(int[] arr, int tar) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {

			int j = i + 1, k = arr.length - 1;
			while (j < k) {
				int sum = arr[j] + arr[k] + arr[i];
				if (sum < tar) {
					System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
					count += k - j;
					j++;
				} else {
					k--;
				}
			}
		}

		return count;
	}
}
