package DataStructures.StackOps;

import java.util.Stack;

public class ReverseUsingStack {

	// http://www.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/

	public static void main(String[] args) {
		System.out.println(reverse("hello world"));

	}

	public static String reverse(String str) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			st.push(str.charAt(i));
		}

		String rv = "";

		while (!st.isEmpty()) {
			rv += st.pop();
		}

		return rv;
	}

}
