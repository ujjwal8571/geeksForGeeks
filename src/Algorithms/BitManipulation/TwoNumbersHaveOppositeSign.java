package Algorithms.BitManipulation;

public class TwoNumbersHaveOppositeSign {

	public static void main(String[] args) {

		int num1 = 12, num2 = 65;

		// sign bit of negative numbers is always 0
		// xor of the msb sign bit of the numbers will always be 1 if they are of
		// opposite signs
		
		if ((num1 ^ num2) < 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
