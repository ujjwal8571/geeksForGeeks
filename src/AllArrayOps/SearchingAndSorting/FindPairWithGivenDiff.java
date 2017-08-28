package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class FindPairWithGivenDiff {

	public static void main(String[] args) {
		int[] arr = {5, 20, 3, 2, 50, 80};
		printPairWithGivenDiff(arr,78);
	}

	public static void printPairWithGivenDiff(int[] arr, int diff) {

		Arrays.sort(arr);

		int i = 0, j = 1;
		while (i < arr.length && j < arr.length) {
			int tempDiff = arr[j] - arr[i];

			if (tempDiff == diff) {
				System.out.println(arr[i] + " ," + arr[j]);
				return;
			} else if (tempDiff < diff) {
				j++;
			} else {
				i++;
			}

		}

		System.out.println("not found");

	}

}
