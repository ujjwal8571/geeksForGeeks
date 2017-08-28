package DataStructures.StackOps;

import java.util.Stack;

public class StackSortUsingRecursion {

	// http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(30);
		st.push(20);
		st.push(50);
		st.push(10);
		st.push(40);

		stacksort(st);
		System.out.println(st);
	}

	public static void stacksort(Stack<Integer> st) {

		if (st.isEmpty()) {
			return;
		}

		int val = st.pop();

		stacksort(st);

		addToStack(st, val);
	}

	public static void addToStack(Stack<Integer> st, int val) {
		if (st.isEmpty() || st.peek() > val) {
			st.push(val);
			return;
		}

		int temp = st.pop();
		addToStack(st, val);
		st.push(temp);
	}

}
