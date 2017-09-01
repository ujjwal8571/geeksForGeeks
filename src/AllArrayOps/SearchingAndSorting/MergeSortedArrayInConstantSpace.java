package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

import AllArrayOps.ArrayBasic;

public class MergeSortedArrayInConstantSpace extends ArrayBasic {

	public static void main(String[] args) {

		int[] arr1 = { 1, 5, 9, 15, 20 };
		int[] arr2 = { 2, 3, 8, 13 };

		mergeTwoSortedArray(arr1, arr2);
		display(arr1);
		display(arr2);
	}

	// constant space
	public static void mergeTwoSortedArray(int[] arr1, int[] arr2) {

		for (int i = arr2.length - 1; i >= 0; i--) {

			int j = arr1.length - 1;

			while (arr1[j] > arr2[i]) {
				int temp = arr1[j];
				arr1[j] = arr2[i];
				arr2[i] = temp;
				j--;
			}

		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

	}

}
