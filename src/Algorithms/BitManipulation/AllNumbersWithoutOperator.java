package Algorithms.BitManipulation;

public class AllNumbersWithoutOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(1 < 2);

		int x = 5;
		int y = 6;

		int carry = 0;
		while (y != 0) {

			carry = x & y;
			x = x ^ y;
			y = carry << 1;

		}

		System.out.println(x);

	}

}
