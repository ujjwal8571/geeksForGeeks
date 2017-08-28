package DataStructures.StackOps;

import java.util.Stack;

public class IsBalanced {

	// http://www.geeksforgeeks.org/?p=6547
	public static void main(String[] args) {
		System.out.println(isBalanced("{()}[]"));
	}

	public static boolean isBalanced(String str) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if ("({[".indexOf(ch) != -1) {
				st.push(ch);
			} else if (")}]".indexOf(ch) != -1) {

				if (ch == ')' && st.peek() == '(') {
					st.pop();
					continue;
				} else if (ch == '}' && st.peek() == '{') {
					st.pop();
					continue;
				} else if (ch == ']' && st.peek() == '[') {
					st.pop();
					continue;
				} else {
					return false;
				}

			}
		}

		if (st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
