package Algorithms.BitManipulation;

public class ToggleLastMBits {

	public static void main(String[] args) {
		System.out.println(toggleLastMBits(107, 4));
	}

	public static int toggleLastMBits(int num, int m) {

		return num ^ ((1 << m) - 1);

	}

}
