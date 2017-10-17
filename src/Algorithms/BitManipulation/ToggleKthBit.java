package Algorithms.BitManipulation;

public class ToggleKthBit {

	public static void main(String[] args) {
		System.out.println(toggleKthBit(5, 1));

	}

	public static int toggleKthBit(int num, int k) {

		return num ^ (1 << k - 1);
	}

}
