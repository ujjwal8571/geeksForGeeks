package Algorithms.BitManipulation;

public class CountSetBits {

	public static void main(String[] args) {

		
		System.out.println(findSetBits(6));
	}

	public static int findSetBits(int num) {

		int rv = 0;

		while (num > 0) {
			num = num & (num - 1);

			rv++;
		}

		return rv;
	}
}
