package DataStructures.StackOps;

import java.util.Stack;

public class ReverseStackByRecursion {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		
		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}

	public static void reverse(Stack<Integer> st) {

		if (st.isEmpty()) {
			return;
		}
		int val = st.pop();

		reverse(st);
		insertAtBottom(st, val);
	}

	
	public static void insertAtBottom(Stack<Integer> st,int val) {
		
		if(st.isEmpty()) {
			st.push(val);
			return;
		}
		
		int temp = st.pop();
		insertAtBottom(st, val);
		st.push(temp);
	}
}
