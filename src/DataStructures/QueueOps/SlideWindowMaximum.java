package DataStructures.QueueOps;

import java.util.LinkedList;

public class SlideWindowMaximum {

	// http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
	public static void main(String[] args) {
		int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
		findMax(arr, 3);
	}

	public static void findMax(int[] arr, int k) {

		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			int val = arr[i];

			while (!queue.isEmpty() && arr[queue.getLast()] <= val) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		for (int i = k; i < arr.length; i++) {
			int val = arr[i];

			System.out.println(arr[queue.getFirst()]);

			// removes elements that hae gone out of current window
			while (!queue.isEmpty() && queue.getFirst() <= i - k) {
				queue.removeFirst();
			}

			// removes elements that are useless aka smaller than the upcoming value
			while (!queue.isEmpty() && arr[queue.getLast()] < val) {
				queue.removeLast();
			}

			queue.addLast(i);

		}

		System.out.println(arr[queue.getFirst()]);

	}
}
