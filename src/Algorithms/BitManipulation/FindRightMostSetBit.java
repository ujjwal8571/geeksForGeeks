package Algorithms.BitManipulation;

public class FindRightMostSetBit {

	public static void main(String[] args) {
		System.out.println(findRightMostSetBit(12));

	}

	public static int findRightMostSetBit(int num) {

		for (int i = 0; i < 32; i++) {
			int bit = 1 << i;

			if ((num & bit) != 0) {
				return bit;
			}
		}

		return 0;
	}

}
