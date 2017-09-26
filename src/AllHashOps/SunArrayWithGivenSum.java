package AllHashOps;

import java.util.HashMap;

public class SunArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 11 };
		findSumArrayWithGivenSum2(arr, -9);
	}

	// only for positive integers in array
	public static void findSumArrayWithGivenSum(int[] arr, int target) {

		int sum = 0;
		int start = 0;
		for (int end = 0; end < arr.length; end++) {
			int val = arr[end];
			sum += val;
			if (sum == target) {
				System.out.println(start + "," + end);
				return;
			} else if (sum < target) {
				// do nothing
			} else {

				while (start <= end && sum > target) {

					sum -= arr[start];
					start++;

					if (sum == target) {
						System.out.println(start + "," + end);
						return;
					}
				}
			}
		}
	}

	// handles both positive and negative
	public static void findSumArrayWithGivenSum2(int[] arr, int target) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {

			currSum += arr[i];

			if (currSum == target) {
				System.out.println(0 + "--" + i);
			}

			if (hm.containsKey(currSum - target)) {
				System.out.println((hm.get(currSum - target) + 1) + "--" + i);
			}

			hm.put(currSum, i);
		}
	}

}
