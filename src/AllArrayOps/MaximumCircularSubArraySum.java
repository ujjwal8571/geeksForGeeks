package AllArrayOps;

public class MaximumCircularSubArraySum {

	public static void main(String[] args) {
		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
		System.out.println(maxInCurcularArray(arr));
	}

	public static int maxInCurcularArray(int[] arr) {

		int kadaneMax = kadane(arr);

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			arr[i] = -1 * arr[i];
		}

		int otherAns = sum + kadane(arr);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1 * arr[i];
		}

		return Math.max(kadaneMax, otherAns);

	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println();
	}

	public static int kadane(int[] arr) {

		int maxSum = 0, tempSum = 0;

		for (int i = 0; i < arr.length; i++) {

			tempSum += arr[i];

			if (tempSum < 0) {
				tempSum = 0;

			} else {

				if (tempSum > maxSum) {
					maxSum = tempSum;

				}

			}

		}

		return maxSum;
	}

}
