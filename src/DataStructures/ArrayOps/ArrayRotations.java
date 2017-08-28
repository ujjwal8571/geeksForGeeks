package DataStructures.ArrayOps;

public class ArrayRotations {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		// rotateReverse(arr, 5);
		blockSwapRotate(arr, 0, arr.length - 1, 5);
		display(arr);

	}

	public static void 	display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static void arrayrotate(int[] arr, int rots) {

		int jugg = gcd(arr.length, rots);
		int ctr = 0;
		while (ctr < jugg) {
			int val = arr[arr.length - ctr - 1];
			int tempVal = arr[jugg - ctr - 1];

			int temp = 0;
			for (int i = arr.length - ctr - jugg - 1; i >= 0; i = i - jugg) {
				temp = arr[i];
				arr[i] = val;
				val = temp;
			}

			arr[arr.length - ctr - 1] = tempVal;

			ctr++;
		}

	}

	public static int gcd(int num1, int num2) {
		int rv;

		while (num1 % num2 != 0) {
			int rem = num1 % num2;
			num1 = num2;
			num2 = rem;

		}
		rv = num2;

		return rv;

	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static void rotateReverse(int[] arr, int rots) {

		reverse(arr, 0, rots - 1);
		reverse(arr, rots, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

	}

	public static void reverse(int[] arr, int start, int end) {

		for (int i = start, j = end; i < j; i++, j--) {
			swap(arr, i, j);
		}

	}

	// helper function to swap array elements
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void blockSwapRotate(int[] arr, int startIdx, int endIdx, int rots) {

		int startA = startIdx;
		int endA = startA + rots - 1;
		int startB = endA + 1;
		int endB = endIdx;
		int lenA = rots;
		int lenB = endB - startB + 1;

		if (lenA == lenB) {
			blockSwap(arr, startA, startB, lenB);
			return;
		}

		if (lenA == 0 || lenB == 0) {
			return;
		}

		if (lenA < lenB) {
			blockSwap(arr, startA, endB - lenA + 1, lenA);

			blockSwapRotate(arr, startIdx, endIdx - lenA, rots);

		} else {
			blockSwap(arr, startA, startB, lenB);
			blockSwapRotate(arr, startIdx + lenB, endIdx, rots);
		}

	}

	public static void blockSwap(int[] arr, int start1, int start2, int size) {

		int i = start1, j = start2;
		int ctr = 0;
		while (ctr < size) {
			int temp = arr[i + ctr];
			arr[i + ctr] = arr[j + ctr];
			arr[j + ctr] = temp;
			ctr++;
		}
		// dispArr(arr);

	}

}
