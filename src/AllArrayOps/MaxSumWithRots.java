package AllArrayOps;

public class MaxSumWithRots {

	public static void main(String[] args) {
		int[] arr = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(maxSumWithRotations(arr));
	}

	// use maths for diff between s1 ans s0 where s1 is sum after frst rotation
	public static int maxSumWithRotations(int[] arr) {

		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
		}

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			int sum = arrSum - (arr.length * arr[arr.length - i - 1]);
			System.out.println(sum);

			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;

	}
}
