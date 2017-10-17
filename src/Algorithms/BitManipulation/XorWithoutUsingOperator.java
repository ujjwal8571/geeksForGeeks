package Algorithms.BitManipulation;

public class XorWithoutUsingOperator {

	public static void main(String[] args) {

		System.out.println(findXor(2, 3));
	}

	public static int findXor(int x, int y) {

		return (x | y) & (~x | ~y);
	}
}
