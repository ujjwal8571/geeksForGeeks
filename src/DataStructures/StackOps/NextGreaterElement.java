package DataStructures.StackOps;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

	// http://www.geeksforgeeks.org/?p=8405
	public static void main(String[] args) {

//		Scanner scn = new Scanner(System.in);
//		int t = scn.nextInt();
//		
//		while(t>0) {
//			
//			int n = scn.nextInt();
//			
//			int[] arr = new int[n];
//			
//			for(int i=0;i<arr.length;i++) {
//				arr[i] = scn.nextInt();
//			}
//			
//			print
//			
//			t--;
//		}
//		
		
		
		int[] arr = { 11, 13, 3, 21, 9 };
		printNextGreater(arr);
	}

	public static void printNextGreater(int[] arr) {

		Stack<Integer> st = new Stack<>();

		for (int val : arr) {

			if (st.isEmpty()) {
				st.push(val);
			} else {

				while (!st.isEmpty()) {

					int stTop = st.pop();
					if (stTop < val) {
						System.out.println(stTop + " -- " + val);
					} else {
						st.push(stTop);

						break;
					}

				}

				st.push(val);
			}

			// System.out.p rintln(st);
		}

		while (!st.isEmpty()) {
			System.out.println(st.pop() + "-- " + -1);
		}
	}

}
