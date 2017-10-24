package Algorithms.DynamicProgramming;

public class MaxSsSumWithNo3Cons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(maxSsSumWithNo3Cons(arr));
	}

	public static int maxSsSumWithNo3Cons(int[] arr) {

		int[] strg = new int[arr.length];

		strg[0] = arr[0];
		strg[1] = arr[1] + arr[0];

		for (int i = 2; i < strg.length; i++) {

			if (i >= 3) {
				strg[i] = Math.max(arr[i] + arr[i - 1] + strg[i - 3], Math.max(arr[i] + strg[i - 2], strg[i - 1]));
			} else {
				strg[i] = Math.max(arr[i] + arr[i - 1], Math.max(arr[i] + strg[i - 2], strg[i - 1]));
			}

		}

		for (int val : strg) {
			System.out.print(val + ", ");
		}
		System.out.println();

		return strg[strg.length - 1];
	}

}
