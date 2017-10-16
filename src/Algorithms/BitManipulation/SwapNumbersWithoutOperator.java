package Algorithms.BitManipulation;

public class SwapNumbersWithoutOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 12, y = 34;

		x = x ^ y;
		y = x ^ y;
		x = x ^ y;

		System.out.println(x + "," + y);

	}

}
