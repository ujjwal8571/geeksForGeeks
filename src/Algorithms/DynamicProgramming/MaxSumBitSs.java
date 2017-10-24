package Algorithms.DynamicProgramming;

public class MaxSumBitSs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };

		System.out.println(maxSumBitonicSs(arr));
	}

	public static int maxSumBitonicSs(int[] arr) {

		int[] mslis = new int[arr.length]; // max sum of lis
		int[] mslds = new int[arr.length]; // max sum for lds

		for (int i = 0; i < arr.length; i++) {
			mslds[i] = arr[i];
			mslis[i] = arr[i];

			for (int j = 0; j < i; j++) {

				// for lis
				if (arr[i] > arr[j] && mslis[i] <= mslis[j] + arr[i]) {

					mslis[i] = mslis[j] + arr[i];
				}

			}
		}
		for (int i = arr.length - 2; i >= 0; i--)
			for (int j = arr.length - 1; j > i; j--)
				if (arr[i] > arr[j] && mslds[i] < mslds[j] + arr[i])
					mslds[i] = mslds[j] + arr[i];

		for (int val : mslds) {
			System.out.print(val + " ,");
		}
		System.out.println();

		int rv = 0;

		for (int i = 0; i < arr.length; i++) {
			int temp = mslis[i] + mslds[i] - arr[i];

			if (temp > rv) {
				rv = temp;
			}
		}

		return rv;

	}

}
