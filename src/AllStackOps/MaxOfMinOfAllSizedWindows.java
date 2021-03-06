package AllStackOps;

import java.util.Arrays;
import java.util.Stack;

import AllArrayOps.ArrayBasic;

public class MaxOfMinOfAllSizedWindows extends ArrayBasic {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
		int[] ans = maxOfMinsOfAllWindows(arr);

		for (int i = 1; i < ans.length; i++) {
			System.out.print(ans[i] + ",");
		}
		System.out.println(".");
	}

	public static int[] maxOfMinsOfAllWindows(int[] arr) {

		int[] ans = new int[arr.length + 1];
		int[] nse = nextSmallerElement(arr);
		int[] pse = prevSmallerElement(arr);

		// making temp answer array

		for (int i = 0; i < ans.length - 1; i++) {

			int myWindow = nse[i] - pse[i] - 1;

			ans[myWindow] = Math.max(ans[myWindow], arr[i]);

		}

		// filling the remaining blanks

		for (int i = ans.length - 2; i >= 0; i--) {

			ans[i] = Math.max(ans[i], ans[i + 1]);

		}

		return ans;

	}

	public static int[] nextSmallerElement(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] rv = new int[arr.length];
		Arrays.fill(rv, 7);
		st.push(0);
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] > arr[st.peek()]) {
				st.push(i);
			} else {

				while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
					int idx = st.pop();
					rv[idx] = i;

				}
				st.push(i);

			}
		}

		return rv;

	}

	public static int[] prevSmallerElement(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int[] rv = new int[arr.length];
		Arrays.fill(rv, -1);
		st.push(arr.length - 1);
		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] > arr[st.peek()]) {
				st.push(i);
			} else {

				while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
					int idx = st.pop();
					rv[idx] = i;

				}
				st.push(i);

			}
		}

		return rv;

	}

}
