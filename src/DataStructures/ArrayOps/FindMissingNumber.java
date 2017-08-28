package DataStructures.ArrayOps;

public class FindMissingNumber {

	// http://www.geeksforgeeks.org/find-the-missing-number/
	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 5, 6 };
		System.out.println(findMissingNumber(arr));
	}

	public static int findMissingNumber(int[] arr) {
		int n = arr.length;
		int reqdSum = ((n + 1) * (n + 2)) / 2;

		int sum = 0;

		for (int val : arr) {
			sum += val;
		}

		return reqdSum - sum;
	}

}
