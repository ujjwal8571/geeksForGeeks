package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class FinfSubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 0, 0, 3, 10, 5 };
		printSubArrayWithGivenSum(arr, 7);
	}

	public static void printSubArrayWithGivenSum(int[] arr, int sum) {

		int startIdx = -1, endIdx = -1;
		int sumTillNow = 0;

		int i = 0;
		while (i < arr.length) {

			if (sumTillNow == sum) {
				break;
			} else if (sumTillNow < sum) {

				if (startIdx == -1) {
					startIdx = i;
				}
				endIdx = i;
				sumTillNow += arr[i];
				i++;
			} else if (sumTillNow > sum) {
				sumTillNow -= arr[startIdx];
				startIdx++;
			}

			if (startIdx > endIdx) {
				return;
			}
		}

		for (int k = startIdx; k <= endIdx; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println();

	}

}
