package DataStructures.ArrayOps;

public class SearchingInSortedRotatedArray {

	// http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	public static void main(String[] args) {

		int[] arr = { 6, 7, 8, 1, 2, 3, 4, 5 };
		// System.out.println(findInRotatedSorted(arr, 9));
		System.out.println(findUsingBinary(arr, 0, arr.length - 1, 9));
	}

	public static boolean findInRotatedSorted(int[] arr, int val) {
		int pivot = findPivotIndex(arr);

		if (val >= arr[0]) {
			return BinarySearch(arr, 0, pivot, val);
		} else {
			return BinarySearch(arr, pivot + 1, arr.length - 1, val);
		}
	}

	public static int findPivotIndex(int[] arr) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (mid < right && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (mid > left && arr[mid] < arr[mid - 1]) {
				return mid - 1;

			} else if (arr[mid] > arr[left]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return 0;
	}

	public static boolean BinarySearch(int[] arr, int left, int right, int val) {

		while (left <= right) {
			int mid = (left + right) / 2;
			mid = mid % arr.length;

			if (arr[mid] == val) {
				return true;
			} else if (arr[mid] < val) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return false;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// alternative recursive approach

	public static boolean findUsingBinary(int[] arr, int left, int right, int val) {

		if (left > right) {
			return false;
		}

		int mid = (left + right) / 2;

		if (arr[mid] == val) {
			return true;
		}

		if (arr[mid] > arr[left]) { // left sorted
			if (val >= arr[left] && val < arr[mid]) {
				return findUsingBinary(arr, left, mid - 1, val);
			} else {
				return findUsingBinary(arr, mid + 1, right, val);
			}
		} else {
			if (val <= arr[right] && val > arr[mid]) {
				return findUsingBinary(arr, mid + 1, right, val);
			} else {
				return findUsingBinary(arr, left, mid - 1, val);
			}
		}
	}
}
