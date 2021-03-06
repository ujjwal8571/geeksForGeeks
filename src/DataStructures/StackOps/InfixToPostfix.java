package DataStructures.StackOps;

import java.util.Stack;

public class InfixToPostfix {

	// http://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/

	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";

		System.out.println(inToPost(str));
	}

	public static String inToPost(String str) {
		String rv = "";

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int val = (int) ch;
			// System.out.println(val);
			if (val >= 97 && val <= 122) {
				rv += ch;
			} else {
				int myPref = preference(ch);
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {

					if (ch == '(') {
						stack.push(ch);

					} else if (ch == ')') {

						while (!stack.isEmpty() && stack.peek() != '(') {
							rv += stack.pop();
						}
						stack.pop();

					} else {
						while (true) {

							if (stack.isEmpty()) {
								stack.push(ch);
								break;
							}
							char stackTop = stack.peek();

							int topPref = preference(stackTop);
							if (topPref < myPref) {
								stack.push(ch);
								break;
							} else {
								rv += stack.pop();

							}
						}
					}
				}

			}

			System.out.println(ch + "," + stack + ", " + rv);
		}
		while (!stack.isEmpty()) {
			rv += stack.pop();
		}

		return rv;
	}

	public static int preference(char ch) {

		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		}

		return 0;
	}
}
