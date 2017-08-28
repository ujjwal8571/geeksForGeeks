package AllArrayOps;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		int[] arr = { 12, 4, 78, 90, 45, 23 };
		System.out.println(longestBitonicSs(arr));
	}

	public static int longestBitonicSs(int[] arr) {

		int[] incArr = new int[arr.length];
		int[] decArr = new int[arr.length];

		incArr[0] = 1;

		// array filling... yha tk sbse lamba subarray jo increasing hai
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				incArr[i] = incArr[i - 1] + 1;
			} else {
				incArr[i] = 1;
			}
		}

		decArr[decArr.length - 1] = 1;

		// array filling.. yha se sbse lamba subarray jo decreasing hai
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				decArr[i] = decArr[i + 1] + 1;
			} else {
				decArr[i] = 1;
			}
		}

		int rv = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int temp = incArr[i] + decArr[i] - 1;

			if (temp > rv) {
				rv = temp;
			}
		}

		return rv;
	}

}
