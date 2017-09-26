package AllStackOps;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidSubString {

	public static void main(String[] args) {

		// Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		// scn.nextLine();
		//
		// while (n > 0) {
		//
		// String str = scn.nextLine();
		// System.out.println(longestValidSs(str));
		// n--;
		// }
		//
		// scn.close();

		String str = "(((((()))(()(((())())())(()(()(()";
		System.out.println(longestValidSs(str));

	}

	public static int longestValidSs(String str) {

		int tempMax = 0;
		int rv = 0;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(') {

				st.push(ch);

			} else { // ch == ')'

				if (!st.isEmpty()) {
					st.pop();
					tempMax += 2;
				} else {
					if (tempMax > rv) {
						rv = tempMax;
					}
					tempMax = 0;

				}

			}

		}

		if (tempMax > rv) {
			rv = tempMax;
		}

		rv-= st.size();

		return rv;
	}

}
