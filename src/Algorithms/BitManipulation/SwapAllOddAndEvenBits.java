package Algorithms.BitManipulation;

public class SwapAllOddAndEvenBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int swapOddAndEvenBits(int num) {

		int oddBits = num & 0xAAAAAAAA;
		int evenBits = num & 0x55555555;

		oddBits <<= 1;
		evenBits >>= 1;

		return oddBits | evenBits;

	}
}
