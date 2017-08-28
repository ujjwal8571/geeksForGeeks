package DataStructures.ArrayOps;

public class elementOccuringOddTimes {

	// http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
	public static void main(String[] args) {

		int arr[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };

		System.out.println(elementoccuringOddTimes(arr));
	}

	public static int elementoccuringOddTimes(int[] arr) {

		int rv = 0;

		for (int val : arr) {
			rv = rv ^ val;
		}

		return rv;
	}

}
