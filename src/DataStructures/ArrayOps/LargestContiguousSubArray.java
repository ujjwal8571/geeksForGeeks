package DataStructures.ArrayOps;

public class LargestContiguousSubArray {

	// http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	public static void main(String[] args) {

		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] ans = largestContiguousSubArray(arr);

		for (int val : ans) {
			System.out.print(val + ", ");

		}
		System.out.println("END");
	}

	public static int[] largestContiguousSubArray(int[] arr) {
		int[] rv;

		int startIdx = -1, endIdx = -1, maxSum = 0, tempSum = 0;

		for (int i = 0; i < arr.length; i++) {

			tempSum += arr[i];

			if (tempSum < 0) {
				tempSum = 0;
				startIdx = i + 1;
			} else {

				if (tempSum > maxSum) {
					maxSum = tempSum;
					endIdx = i;
				}

			}

		}

		rv = new int[endIdx - startIdx + 1];
		int k = 0;
		for (int i = startIdx; i <= endIdx; i++) {
			rv[k] = arr[i];
			k++;
		}

		return rv;
	}

}
