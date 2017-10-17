package Algorithms.BitManipulation;

public class ToggleAllBitsExceptKthBit {

	public static long maxBit = 4294967295L; // all 32 bits are set

	public static void main(String[] args) {

		System.out.println(toggleAllBitsExceptKthBit(1, 0));

	}

	public static long toggleAllBitsExceptKthBit(long num, int k) {

		int bit = 1 << (k);

		long tempBit = maxBit ^ bit;

		return (num ^ tempBit);
	}

}
