package Algorithms.BitManipulation;

public class CountBitFlipsForAxorBequalC {

	public static void main(String[] args) {
		String a = "10100";
		String b = "00010";
		String c = "10011";

		System.out.println(countBitFlips2(a, b, c));

	}

	public static int countBitFlips(String a, String b, String c) {

		int rv = 0;

		for (int i = 0; i < c.length(); i++) {

			char a1 = a.charAt(i);
			char b1 = b.charAt(i);
			int val1 = a1 - '0';
			int val2 = b1 - '0';

			if ((val1 ^ val2) != (c.charAt(i) - '0')) {
				rv++;
			}
		}

		return rv;
	}

	public static int countBitFlips2(String a, String b, String c) {

		int rv = 0;

		for (int i = 0; i < c.length(); i++) {
			if (a.charAt(i) == b.charAt(i) && c.charAt(i) == '1') {
				rv++;
			}
			
			
			if (a.charAt(i) != b.charAt(i) && c.charAt(i) == '0') {
				rv++;
			}
		}

		return rv;

	}
}
