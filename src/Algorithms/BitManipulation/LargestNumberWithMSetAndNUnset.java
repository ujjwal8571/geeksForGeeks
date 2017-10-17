package Algorithms.BitManipulation;

public class LargestNumberWithMSetAndNUnset {

	public static void main(String[] args) {
		System.out.println(largestNumberWithMandN(2, 2));

	}

	public static int largestNumberWithMandN(int m, int n) {

		int maxBit = ((1 << (m + n)) - 1);
		int minBit = ((1 << n) - 1);

		return maxBit ^ minBit;
	}

}
