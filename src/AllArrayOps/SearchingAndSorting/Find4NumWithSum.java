package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class Find4NumWithSum {

	public static void main(String[] args) {
		int[] arr = { 10, 2, 3, 4, 5, 9, 7, 8 };
		// int[] arr = { 1, 2, 3, 4 };
		print4NumWithSumOptimized(arr, 23);
	}

	// o(n3) approach
	// similar to finding triplet
	public static void print4NumWithSum(int[] arr, int sum) {
		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 3; i++) {
			for (int j = i + 1; j < arr.length - 2; j++) {

				int low = j + 1;
				int high = arr.length - 1;

				while (low < high) {
					int temp = arr[i] + arr[j] + arr[low] + arr[high];

					if (temp == sum) {
						System.out.println(arr[i] + ", " + arr[j] + ", " + arr[low] + ", " + arr[high]);
						break;
					} else if (temp < sum) {
						low++;
					} else {
						high--;
					}
				}

			}
		}
	}

	public static class numPair implements Comparable<numPair> {
		int num1;
		int num2;
		int sum;

		@Override
		public int compareTo(numPair o) {
			// TODO Auto-generated method stub
			return this.sum - o.sum;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Integer.toString(this.sum);
		}
	}

	// with o(n2logn) time and o(n2) space
	public static void print4NumWithSumOptimized(int[] arr, int sum) {

		numPair[] sumArr = new numPair[(arr.length * (arr.length - 1)) / 2];
		int idx = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tSum = arr[i] + arr[j];

				numPair p = new numPair();
				p.num1 = arr[i];
				p.num2 = arr[j];
				p.sum = tSum;
				sumArr[idx] = p;
				idx++;
			}

		}

		Arrays.sort(sumArr);

		int i = 0, j = sumArr.length - 1;
		while (i < j) {
			int tempSum = sumArr[i].sum + sumArr[j].sum;
			if (tempSum == sum) {
				System.out.println(
						sumArr[i].num1 + ", " + sumArr[i].num2 + ", " + sumArr[j].num1 + ", " + sumArr[j].num2);
				break;
			} else if (tempSum < sum) {
				i++;
			} else {
				j--;
			}
		}

	}
}
