package Algorithms.DynamicProgramming;

public class BellNumbers {

	public static void main(String[] args) {

		System.out.println(bellNumbersRecursive(4));
		// System.out.println(bellNumbersRecursiveHelper(3, 1));
	}

	public static int bellNumbersRecursive(int n) {

		int rv = 0;

		int k = 1;

		while (k <= n) {
			rv += bellNumbersRecursiveHelper(n, k);
			k++;
		}

		return rv;
	}

	public static int bellNumbersRecursiveHelper(int n, int k) {

		if (n == 1 || n == 0) {
			return 1;
		}

		// if (n == k) {
		// return 1;
		// }
		//
		// return k * bellNumbersRecursiveHelper(n - 1, k) +
		// bellNumbersRecursiveHelper(n - 1, k - 1);

		if (k == 0) {
			return bellNumbersRecursiveHelper(n - 1, n - 1);
		} else {
			return bellNumbersRecursiveHelper(n, k - 1) + bellNumbersRecursiveHelper(n - 1, k - 1);
		}

	}
}
