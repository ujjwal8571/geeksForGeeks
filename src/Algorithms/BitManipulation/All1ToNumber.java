package Algorithms.BitManipulation;

public class All1ToNumber {

	public static void main(String[] args) {

		System.out.println(addOneToNumber(23));
	}

	public static int addOneToNumber(int num) {

		int carry = 0;
		int bit = 1;
		while (true) {

			carry = num & bit;
			num = num ^ bit;

			bit = bit << 1;
			if (carry == 0) {
				break;
			}

		}

		if (carry == 1) {
			num = num ^ bit;
		}

		return num;

	}

}
