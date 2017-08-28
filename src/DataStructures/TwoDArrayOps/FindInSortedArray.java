package TwoDArrayOps;

public class FindInSortedArray {

	public static void main(String[] args) {
		int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		System.out.println(findInSortedArray(mat, 200));
	}

	public static boolean findInSortedArray(int[][] arr, int key) {

		int currPosy = arr[0].length - 1;
		int currPosx = 0;

		while (true) {

			int currVal = arr[currPosx][currPosy];

			if (currVal == key) {

				return true;
			} else if (currVal > key) {

				currPosy--;
				if (currPosy < 0) {
					return false;
				}

			} else {

				currPosx++;
				if (currPosx == arr.length) {
					return false;
				}

			}
		}

	}

}
