package DataStructures.StackOps;

import java.util.Stack;

public class PostfixEvaluation {

	// http://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/

	public static void main(String[] args) {
		String str = "231*+9-";
		;
		System.out.println(evaluatePostfix(str));
	}

	public static int evaluatePostfix(String str) {
		int rv = 0;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int val = Integer.valueOf(ch);

			if (val >= 48 && val <= 58) {
				st.push(val - 48);
			} else {
				if (ch == '+') {
					int val1 = st.pop();
					int val2 = st.pop();

					int ans = val1 + val2;
					st.push(ans);

				} else if (ch == '-') {

					int val1 = st.pop();
					int val2 = st.pop();

					int ans = val2 - val1;
					st.push(ans);

				} else if (ch == '*') {

					int val1 = st.pop();
					int val2 = st.pop();

					int ans = val2 * val1;
					st.push(ans);

				} else if (ch == '/') {
					int val1 = st.pop();
					int val2 = st.pop();

					int ans = val2 / val1;
					st.push(ans);

				}

			}
			System.out.println(st);
		}
		rv = st.pop();
		return rv;

	}

}
