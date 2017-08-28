package AllArrayOps.SearchingAndSorting;

public class FindPeakElement {

	public static void main(String[] args) {

		int[] arr = { 10,20,30,40,50,44 };
//		printPeakElements(arr);
		System.out.println(findPeakElement(arr, 0, arr.length - 1));
	}

	// naive approach in o(n)

	public static void printPeakElements(int[] arr) {

		if (arr[0] > arr[1]) {
			System.out.println(arr[0]);
		}

		for (int i = 1; i < arr.length - 1; i++) {

			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				System.out.println(arr[i]);
			}
		}

		if (arr[arr.length - 1] > arr[arr.length - 2]) {
			System.out.println(arr[arr.length - 1]);
		}

	}

	// optimized approach using binary search
	public static int findPeakElement(int[] arr, int start, int end) {

		int mid = (start + end) / 2;
		if ((mid == 0 && arr[mid] > arr[mid + 1]) || (mid == arr.length - 1 && arr[mid] > arr[mid - 1])
				|| (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) {
			return arr[mid];
		} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
			return findPeakElement(arr, start, mid - 1);
		} else {
			return findPeakElement(arr, mid + 1, end);
		}

	}

}
