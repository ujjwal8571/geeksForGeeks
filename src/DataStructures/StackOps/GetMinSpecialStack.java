package DataStructures.StackOps;

import java.util.Stack;

// http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

public class GetMinSpecialStack {

	Stack<Integer> st = new Stack<>();
	Stack<Integer> min = new Stack<>();

	public void push(int val) {

		if (st.isEmpty()) {
			st.push(val);
			min.push(val);
			return;
		}

		int minTop = min.peek();
		st.push(val);

		if (minTop > val) {
			min.push(val);
		} else {
			min.push(minTop);
		}

	}

	public int pop() {
		if (st.isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}

		int rv = st.pop();
		min.pop();

		return rv;
	}

	public int getMin() {
		return min.peek();
	}
}
