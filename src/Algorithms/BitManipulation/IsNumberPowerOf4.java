package Algorithms.BitManipulation;

public class IsNumberPowerOf4 {

	public static void main(String[] args) {

		System.out.println(isNumberPowerOf4(16));
	}

	public static boolean isNumberPowerOf4(int num) {

		int idx = -1;

		for (int i = 0; i < 32; i++) {

			int bit = 1 << i;
			int ithBit = num & bit;

			if (ithBit != 0) {
				if (idx != -1) {

					return false;
				} else {
					idx = i;
				}
			}

		}
		if (idx % 4 == 0) {
			return true;
		} else {
			return false;
		}

	}

}
