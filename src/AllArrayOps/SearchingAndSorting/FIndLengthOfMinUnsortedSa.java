package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

import AllArrayOps.ArrayBasic;

public class FIndLengthOfMinUnsortedSa extends ArrayBasic {

	public static void main(String[] args) {
		int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50 };
		printMinUnsortedSubArray(arr);
	}

	public static void printMinUnsortedSubArray(int[] arr) {

		int firstIdx = -1;
		int lastIdx = -1;
		int maxInUnsortedArray = -1, minInUnsortedArray = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				if (firstIdx == -1) {
					firstIdx = i;
					maxInUnsortedArray = arr[i];
					minInUnsortedArray = arr[i];
				} else {
					lastIdx = i + 1;

					if (arr[i] > minInUnsortedArray) {
						minInUnsortedArray = arr[i];
					}

					if (arr[i] > maxInUnsortedArray) {
						maxInUnsortedArray = arr[i];
					}
				}
			}

		}

		if (lastIdx == -1) {
			lastIdx = firstIdx + 1;

			if (arr[lastIdx] < minInUnsortedArray) {
				minInUnsortedArray = arr[lastIdx];
			}
		}

		int start = firstIdx;

		for (int i = start; i >= 0; i--) {
			if (arr[i] < minInUnsortedArray) {
				firstIdx = i ;
				break;
			}
		}

		start = lastIdx;
		for (int i = start; i < arr.length; i++) {

			if (arr[i] > maxInUnsortedArray) {
				lastIdx = i - 1;
				break;
			}
		}

		System.out.println(firstIdx + "," + lastIdx);
		
		Arrays.sort(arr, firstIdx, lastIdx);
		display(arr);

	}

}
