package AllHeapOps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectAllRopes {

	public static void main(String[] args) {
		// int[] arr = {4,3,2,6};
		// System.out.println(connectAllRopes(arr));

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		while (t > 0) {

			int r = scn.nextInt();
			int[] arr = new int[r];

			for (int i = 0; i < arr.length; i++) {

				arr[i] = scn.nextInt();
			}

			System.out.println(connectAllRopes(arr));

			t--;
		}

	}

	public static int connectAllRopes(int[] arr) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int rv = 0;
		for (int val : arr) {
			pq.add(val);
		}

		while (pq.size() != 1) {

			int one = pq.remove();
			int two = pq.remove();

			int ans = one + two;
			rv += ans;
			pq.add(ans);
		}

		return rv;
	}
}
