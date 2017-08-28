package AllArrayOps;

import java.util.ArrayList;

public class PartitionProblem {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 7 };
		// System.out.println(partionProblemRec(arr, 0, new ArrayList<>(), new
		// ArrayList<>()));

		// System.out.println(partitionProblemRecNoSpace(arr));
		System.out.println(partitionProblemDp(arr));
	}

	// recursive approach
	public static boolean partionProblemRec(int[] arr, int vidx, ArrayList<Integer> list1, ArrayList<Integer> list2) {

		if (vidx == arr.length) {
			int sum1 = 0;
			int sum2 = 0;

			for (int val : list1) {
				sum1 += val;
			}

			for (int val : list2) {
				sum2 += val;
			}

			if (sum1 == sum2) {
				System.out.println(list1);
				System.out.println(list2);
				return true;
			}
			return false;
		}

		list1.add(arr[vidx]);
		boolean recAns1 = partionProblemRec(arr, vidx + 1, list1, list2);
		list1.remove(list1.size() - 1);

		list2.add(arr[vidx]);

		boolean recAns2 = partionProblemRec(arr, vidx + 1, list1, list2);
		list2.remove(list2.size() - 1);

		if (recAns1 || recAns2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean partitionProblemRecNoSpace(int[] arr) {

		int sum = 0;
		for (int val : arr) {
			sum += val;
		}

		if (sum % 2 == 1) {
			return false;
		}

		return subArrayWithSum(arr, 0, 0, sum / 2);
	}

	public static boolean subArrayWithSum(int[] arr, int vidx, int currSum, int sum) {

		if (vidx == arr.length) {
			if (sum == currSum) {
				return true;
			} else {
				return false;
			}
		}

		boolean recAns1 = subArrayWithSum(arr, vidx + 1, currSum + arr[vidx], sum);
		boolean recAns2 = subArrayWithSum(arr, vidx + 1, currSum, sum);

		if (recAns1 || recAns2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean partitionProblemDp(int[] arr) {

		int sum = 0;
		for (int val : arr) {
			sum += val;
		}

		if (sum % 2 == 1) {
			return false;
		}

		boolean[][] memo = new boolean[sum / 2 + 1][arr.length + 1];

		for (int i = 0; i < memo[0].length; i++) {
			memo[0][i] = true;
		}

		for (int i = 1; i < memo.length; i++) {
			memo[i][0] = false;
		}

		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {

				// mera pichla nhi bna paya tha to mai bhi na bna paunga
				memo[i][j] = memo[i][j - 1];

				if (i >= arr[j - 1]) { // jo lst element aaya hai agar mai usko consume krlo to kya baaki ka array
										// me-consumed element ko bna pega
					memo[i][j] = memo[i][j] || memo[i - arr[j - 1]][j - 1];
				}

			}
		}

		return memo[memo.length - 1][memo[0].length - 1];
	}

}
