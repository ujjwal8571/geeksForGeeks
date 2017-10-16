package Algorithms.BitManipulation;

public class BitRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int leftShift(int num, int d) {

		return (num << d) | (num >> (Integer.SIZE - d));
	}

	public static int rightShift(int num, int d) {

		return (num >> d) | (num << (Integer.SIZE - d));
	}

}
