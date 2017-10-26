package StringOps;

import java.util.Scanner;

public class NumberOfEvenSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		scn.nextLine();

		while (t-- > 0) {
			String str = scn.nextLine();
			System.out.println(numberOfEvenSS(str));
		}
	}

	public static int numberOfEvenSS(String str) {

		int rv = 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Integer.parseInt(String.valueOf(ch)) % 2 == 0) {

				rv += i + 1;
			}
		}
		return rv;
	}

}
