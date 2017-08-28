package AllArrayOps;

import java.util.Arrays;

public class ConvertArrayToZigZag {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 8, 6, 2, 1 };
		display(arr);
		convertArrayToZigZagInOn(arr);
		display(arr);

	}

	// naive approach using sorting and then swapping
	public static void convertArrayToZigZag(int[] arr) {

		Arrays.sort(arr);

		for (int i = 1; i < arr.length - 1; i += 2) {
			swap(arr, i, i + 1);
		}
	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void convertArrayToZigZagInOn(int[] arr) {
		boolean isLeftGreater = false;

		for (int i = 0; i < arr.length - 1; i++) {

			if (isLeftGreater) {
				if (arr[i] > arr[i + 1]) {
					// do nothing
				} else {
					swap(arr, i, i + 1);
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					// do nothing
				} else {
					swap(arr, i, i + 1);
				}
			}
			isLeftGreater = !isLeftGreater;
		}
	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

}
