package TwoDArrayOps;

import java.util.PriorityQueue;

public class PrintSorted {
	// similar to merging k sorted arrays

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// all rows are in sorted form
	public static void printSorted(int[][] arr) {

		int[] indexArray = new int[arr.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			int rowIdx = indexArray[i];
			pq.add(arr[rowIdx][i]);
		}

		// while(!pq.isEmpty()) {
		// int val
		// }

	}
}
