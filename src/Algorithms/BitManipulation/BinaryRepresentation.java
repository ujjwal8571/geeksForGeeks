package Algorithms.BitManipulation;

public class BinaryRepresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBinary(10);
	}

	public static void printBinary(int num) {

		int bit = 1;
		for (int i = 31; i >= 0; i--) {

			bit = 1 << i;
			if ((bit & num) != 0) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
		}
		System.out.println();

	}
}
