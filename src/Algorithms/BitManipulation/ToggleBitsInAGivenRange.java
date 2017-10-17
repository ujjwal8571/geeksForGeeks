package Algorithms.BitManipulation;

public class ToggleBitsInAGivenRange {

	public static void main(String[] args) {
		System.out.println(togleBitsInAGivenRange(17, 2, 3));

	}

	public static int togleBitsInAGivenRange(int num, int l, int r) {

		int bit = ((1 << r) - 1) ^ ((1 << (l - 1)) - 1);

		return num ^ bit;
	}

}
