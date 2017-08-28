package AllArrayOps;

public class FindPairInSortedRotated {

	public static void main(String[] args) {
		int[] arr = { 11, 15, 26, 38, 9, 10 };

		System.out.println(doesAPairExist(arr, 45));
	}

	public static boolean doesAPairExist(int[] arr, int target) {
		int low = pivotIndex(arr);
		int high = ((low - 1) + arr.length) % arr.length;

		while (low != high) {
			if (arr[low] + arr[high] == target) {
				return true;
			} else if (arr[low] + arr[high] < target) {
				low = (low + 1) % arr.length;
			} else {
				high = (high - 1 + arr.length) % arr.length;
			}
		}

		return false;
	}

	public static int pivotIndex(int[] arr) {
		int pivot = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i + 1;
			}
		}

		return pivot;
	}

}
