package Algorithms.BitManipulation;

public class ReverseBitsOfANumber {
	public static int total_bits = Integer.SIZE;

	public static void main(String[] args) {
		System.out.println(reverseBitsOfANumber(2147483648L));

	}

	public static int reverseBitsOfANumber(long num) {

		int ans = 0;
		for (int i = 0; i < 32; i++) {
			if ((num & (1 << i)) != 0) {

				ans |= 1 << (total_bits - i - 1);
			}
		}

		return ans;

	}

}
