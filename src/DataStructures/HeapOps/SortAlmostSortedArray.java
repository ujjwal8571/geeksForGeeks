package DataStructures.HeapOps;

import java.util.PriorityQueue;

public class SortAlmostSortedArray {

	public static void main(String[] args) {

		int k = 3;
		int[] arr = { 2, 6, 3, 12, 56, 8 };

		int[] ans = sortASArray(arr, k);

		for (int val : ans) {
			System.out.print(val + ", ");

		}
		System.out.println("end");

	}

	public static int[] sortASArray(int[] arr, int k) {
		int[] rv = new int[arr.length];
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}
		int idx = 0;

		for (int i = k; i < arr.length; i++) {
			rv[idx] = heap.remove();
			heap.add(arr[i]);
			idx++;
		}

		while (!heap.isEmpty()) {
			rv[idx] = heap.remove();
			idx++;
		}

		return rv;

	}
}
