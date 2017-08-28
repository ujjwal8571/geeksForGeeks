package AllArrayOps.SearchingAndSorting;

public class PositionOfAnElementInInfiniteArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 900, 900, 900, 900, 900, 900, 900, 900,
				900, 900, 900, 900, 900, 900, 900, 900, 900 };

		System.out.println(findPos(arr, 10));
	}

	// infinte array
	// sorted array
	public static int findPos(int[] arr, int data) {

		int low = 0;
		int high = 1;

		while (arr[high] < data) {
			low = high;
			high *= 2;
		}

		return binarySearch(arr, low, high, data);

	}

	public static int binarySearch(int[] arr, int lo, int hi, int data) {

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (arr[mid] == data) {
				return mid;
			} else if (arr[mid] > data) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		return -1;
	}

}
