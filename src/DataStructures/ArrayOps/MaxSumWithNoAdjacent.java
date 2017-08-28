package DataStructures.ArrayOps;

public class MaxSumWithNoAdjacent {

	// http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	public static void main(String[] args) {
		int[] arr = { 5, 5, 10, 100, 10, 5 };

		System.out.println(maxSum(arr));
		
		
	}

	public static int maxSum(int[] arr) {
		int exclusive = 0;
		int inclusive = arr[0];

		for (int i = 1; i < arr.length; i++) {

			int temp = Math.max(exclusive, inclusive);
			inclusive = exclusive + arr[i];
			exclusive = temp;
		}

		return Math.max(inclusive, exclusive);

	}

}
