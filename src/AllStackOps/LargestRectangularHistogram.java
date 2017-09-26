package AllStackOps;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangularHistogram {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("{ 6, 2, 5, 4, 5, 1, 6 }");
		System.out.println(findMaxAreaOfHisto(arr));
	}

	// using stack
	// we need to find the previous smaller element and the next smaller element so
	// we take the help of stack

	public static int findMaxAreaOfHisto(int[] bars) {
		int rv = 0;

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < bars.length; i++) {

			if (st.isEmpty() || (bars[i] > bars[st.peek()])) {
				st.push(i);

			} else {

				int rightIdx = i;
				int rightVal = bars[i];

				while (!st.isEmpty()) {
					rightIdx = i;

					int myIdx = st.pop();
					int myVal = bars[myIdx];

					if (rightVal > myVal) {
						st.push(myIdx);
						break;
					}

					int leftIdx = -1;
					if (!st.isEmpty()) {
						leftIdx = st.peek();
					}

					rightIdx--;
					leftIdx++;

					int myArea = (rightIdx - leftIdx + 1) * myVal;
//					System.out.println(myIdx + ", " + myArea);
//					System.out.println(leftIdx + "," + myIdx + "," + rightIdx);
//					System.out.println();

					if (myArea > rv) {
						rv = myArea;
					}
				}

				st.push(i);

			}

		}

		return rv;
	}

}
