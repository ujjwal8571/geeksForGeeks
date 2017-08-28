package AllArrayOps.SearchingAndSorting;

public class CeilingAndFloorInSortedArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 8, 10, 10, 12, 19 };

		System.out.println(findFloor(arr, 20));
	}

	// using binary search in log n
	public static int findCeiling(int[] arr, int x) {
		int rv = -1;
		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (arr[mid] == x) {
				rv = x;
				break;
			} else if (arr[mid] < x) {

				if (arr[mid] > rv) {
					rv = arr[mid];
				}

				lo = mid + 1;

			} else {
				hi = mid - 1;
			}
		}

		return rv;
	}

	// using binary search in log n
	public static int findFloor(int[] arr, int x) {
		int rv = Integer.MAX_VALUE;
		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (arr[mid] == x) {
				rv = x;
				break;
			} else if (arr[mid] < x) {

				lo = mid + 1;

			} else {

				if (arr[mid] < rv) {
					rv = arr[mid];
				}
				hi = mid - 1;
			}
		}
		if (rv == Integer.MAX_VALUE) {
			rv = -1;
		}

		return rv;
	}

}
