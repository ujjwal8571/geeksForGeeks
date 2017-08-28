package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

import AllArrayOps.ArrayBasic;

public class SUmOfElementsClosestTo0 extends ArrayBasic {

	public static void main(String[] args) {

		int[] arr = { -50, -60, -70, -80, 20, 40, 60, 65 };
		printElementsWithSumCloseTo0(arr);
	}

	public static void printElementsWithSumCloseTo0(int[] arr) {

		Arrays.sort(arr);
		display(arr);

		int minSum = Integer.MAX_VALUE;
		int leftMin = -1, rightMin = -1;

		int i = 0, j = arr.length - 1;

		while (i < j) {
			int sum = arr[j] + arr[i];

			if (Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				leftMin = arr[i];
				rightMin = arr[j];
			}

			if (minSum == 0) {
				break;
			}

			if (Math.abs(arr[i]) > Math.abs(arr[j])) {
				i++;
			} else {
				j--;
			}

		}

		System.out.println(leftMin + ", " + rightMin);
	}

}
