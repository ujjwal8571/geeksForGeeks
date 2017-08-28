package AllArrayOps;

public class FindSortedLength3 {

	public static void main(String[] args) {

		int[] arr = { 12, 11, 10, 15, 6, 2, 3 };
		// printSortedOfLength3(arr);

		printForm(arr);
	}

	public static void printSortedOfLength3(int[] arr) {

		int minIdx = 0;
		int maxIdx = arr.length - 1;
		int[] smaller = new int[arr.length];
		int[] larger = new int[arr.length];

		smaller[0] = -1;
		larger[larger.length - 1] = -1;

		// work to be done in smaller

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] <= arr[minIdx]) {
				minIdx = i;
				smaller[i] = -1;

			} else {
				smaller[i] = minIdx;
			}
		}

		// work for larger
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= arr[maxIdx]) {

				maxIdx = i;
				larger[i] = -1;
			} else {
				larger[i] = maxIdx;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (smaller[i] != -1 && larger[i] != -1) {
				System.out.println(arr[smaller[i]] + "," + arr[i] + "," + arr[larger[i]]);
				return;
			}
		}

		System.out.println("no suck triplet found");

	}

	// Find a subsequence of size 3 such that arr[i] > arr[j] < arr[k].
	public static void printForm(int[] arr) {

		int leftMax = 0;
		int rightMax = arr.length - 1;
		int[] leftlarger = new int[arr.length];
		int[] rightLarger = new int[arr.length];

		leftlarger[0] = -1;
		rightLarger[rightLarger.length - 1] = -1;

		// work to be done in left larger

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] >= arr[leftMax]) {
				leftMax = i;
				leftlarger[i] = -1;

			} else {
				leftlarger[i] = leftMax;
			}
		}

		// work for right larger
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= arr[rightMax]) {

				rightMax = i;
				rightLarger[i] = -1;
			} else {
				rightLarger[i] = rightMax;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (leftlarger[i] != -1 && rightLarger[i] != -1) {
				System.out.println(arr[leftlarger[i]] + "," + arr[i] + "," + arr[rightLarger[i]]);
				return;
			}
		}

		System.out.println("no suck triplet found");

	}

}
