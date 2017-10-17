package Algorithms.BitManipulation;

public class FindTwoNonRepeatingElement {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 7, 9, 4, 2 };
		findTwoNonRepeatingElement(arr);

	}

	public static void findTwoNonRepeatingElement(int[] arr) {

		int xor = 0;
		for (int val : arr) {

			xor = xor ^ val;
		}

		int rmsb = xor & ~(xor - 1); // right most set bit

		int num1 = 0, num2 = 0;

		for (int val : arr) {

			if ((val & rmsb) != 0) {

				num1 = num1 ^ val;
			} else {
				num2 = num2 ^ val;
			}

		}

		System.out.println(num1 + "," + num2);
	}

}
