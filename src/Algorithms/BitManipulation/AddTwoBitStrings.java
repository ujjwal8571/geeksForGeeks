package Algorithms.BitManipulation;

public class AddTwoBitStrings {
	public static void main(String[] args) {
		
		
		String str1 = "100010";
		String str2 = "1110001010";
		
		addBitStrings(str1, str2);
	}

	public static String addBitStrings(String str1, String str2) {

		equalizeLength(str1, str2);
		
		System.out.println(str1);
		System.out.println(str2);
		
		return "";
		
	}

	public static void equalizeLength(String str1, String str2) {

		if (str1.length() == str2.length()) {
			return;
		}

		if (str1.length() > str2.length()) {

			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		

		// now work only on str1

		int d = str2.length() - str1.length();
		String temp = "";

		while (d-- > 0) {
			temp += "0";
		}
		temp += str1;
		str1 = temp;
		
		System.out.println(str1);

	}
}
