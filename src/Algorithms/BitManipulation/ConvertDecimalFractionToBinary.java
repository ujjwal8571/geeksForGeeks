package Algorithms.BitManipulation;

public class ConvertDecimalFractionToBinary {

	public static void main(String[] args) {
		System.out.println(convertDecimalToBinary(6.986));

	}

	public static String convertDecimalToBinary(double num) {
		String rv = "";

		String numberPart = "";
		String decimalPart = "";

		int tempNum = (int) num;

		while (tempNum > 0) {

			int q = tempNum / 2;
			int rem = tempNum % 2;

			numberPart += rem;
			tempNum = q;

		}
		
		numberPart = new StringBuilder(numberPart).reverse().toString();

		// for decimal part

		double decNum = num - (int) num;

		for (int i = 0; i < 8; i++) {

			decNum *= 2;
			decimalPart += (int) decNum;

			decNum = decNum - (int) decNum;

			if (decNum == 0) {
				break;
			}
		}
		
//		decimalPart = new StringBuilder(decimalPart).reverse().toString();

		rv += numberPart + "." + decimalPart;

		return rv;

	}

}
