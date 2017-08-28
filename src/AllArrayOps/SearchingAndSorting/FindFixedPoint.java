package AllArrayOps.SearchingAndSorting;

public class FindFixedPoint {

	public static void main(String[] args) {
int[] arr = {-10, -1, 0, 3, 10, 11, 30, 50, 100};;
		System.out.println(findFixedPoint(arr));
	}

	public static int findFixedPoint(int[] arr) {

		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (arr[mid] == mid) {
				return mid;
			} else if (arr[mid] < mid) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

		return -1;

	}
}
