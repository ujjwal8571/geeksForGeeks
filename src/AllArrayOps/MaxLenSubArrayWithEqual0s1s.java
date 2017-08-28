package AllArrayOps;

import java.util.HashMap;

public class MaxLenSubArrayWithEqual0s1s {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1, 1, 0, 0 };
		System.out.println(findMaxLen(arr));
	}

	public static int findMaxLen(int[] arr) {

		// convert all 0 to -1

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] == 0 ? -1 : 1;
		}

		// work area

		// find max length with sum = 0
		int maxLen = 0;
		int sum = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (sum == 0) {
				maxLen = i + 1;
			}

			if (hm.containsKey(sum)) {
				int prevIdxWithSameSum = hm.get(sum);
				maxLen = Math.max(maxLen, i - prevIdxWithSameSum);
			} else {
				hm.put(sum, i);
			}
		}

		// work area ends

		// convert back all -1 to 0
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] == -1 ? 0 : 1;
		}

		return maxLen;
	}

}
