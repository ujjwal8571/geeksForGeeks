package AllArrayOps;

import java.util.Arrays;

public class RearrangeAccToAbsValue {

	public static void main(String[] args) {
		int[] arr = {10, 5, 3, 9 ,2};
		
		sortAccToAbs(arr, 7);
		display(arr);

	}

	// using self defined pair class and sort acc to abs value
	public static void sortAccToAbs(int[] arr, int k) {
		Pair[] absValues = new Pair[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int abs = Math.abs(k - arr[i]);
			Pair p = new Pair();
			p.data = arr[i];
			p.absValue = abs;
			absValues[i] = p;
		}

		Arrays.sort(absValues);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = absValues[i].data;
		}

	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int absValue;

		@Override
		public int compareTo(Pair o) {

			return this.absValue - o.absValue;
		}

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	// ~~~~~~~~~~ IMPORTANT ~~~~~~~~~~~~~~~~~~~~
	//ONE APPROACH IS USING SELF BALANCING BST
	
	
}
