package Algorithms.BitManipulation;

public class SmallestNumberWithNSetAndMUnsetBits {

	public static void main(String[] args) {

		System.out.println(smallestNumberWithMsetAndNUnset(2, 2));
	}

	public static int smallestNumberWithMsetAndNUnset(int n, int m) {

		int bit = (1 << (n + m)) - 1;

		return ToggleBitsInAGivenRange.togleBitsInAGivenRange(bit, n, n + m - 1);
	}

}
