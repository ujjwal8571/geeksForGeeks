package Algorithms.BitManipulation;

public class CheckForSumOverFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSumOverflow(int a, int b) {

		if (a > Integer.MAX_VALUE - b) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSumOverflow2(int a, int b) {

		int result = a + b;

		if (a > 0 && b > 0 && result < 0) {
			return false;
		} else if (a < 0 && b < 0 && result > 0) {
			return false;
		} else {
			return true;
		}
	}
}
