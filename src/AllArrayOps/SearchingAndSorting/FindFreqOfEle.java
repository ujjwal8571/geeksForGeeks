package AllArrayOps.SearchingAndSorting;

public class FindFreqOfEle {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 2, 2 };

		System.out.println(findFreqOfX(arr, 1));
	}

	// using binary search

	public static int findFreqOfX(int[] arr, int x) {

		int lo = 0, hi = arr.length - 1;

		int startIdx = -1, endIdx = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if ((mid == 0 && arr[mid] == x) || (mid > 0 && arr[mid] == x && arr[mid - 1] != x)) {

				startIdx = mid;
				break;
			} else if (arr[mid] >= x) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		lo = 0;
		hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if ((mid < arr.length - 1 && arr[mid] == x && arr[mid + 1] != x)
					|| (mid == arr.length - 1 && arr[mid] == x)) {
				endIdx = mid;
				break;
			} else if (arr[mid] <= x) {
				lo = mid + 1;
			} else {

				hi = mid - 1;
			}

		}

		if (startIdx == -1 || endIdx == -1) {
			return -1;
		}

		return endIdx - startIdx + 1;
	}

}
