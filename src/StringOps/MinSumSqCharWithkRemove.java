package StringOps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinSumSqCharWithkRemove {

	public static void main(String[] args) {

		System.out.println(minSumSqWithKRemoves("aaab", 2));
	}

	public static int minSumSqWithKRemoves(String str, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			arr[ch - 'a']++;

		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				pq.add(arr[i]);
			}
		}

		while (k-- > 0) {
			int temp = pq.remove();
			temp--;
			pq.add(temp);
		}

		int rv = 0;
		while (!pq.isEmpty()) {

			int temp = pq.remove();
			rv += temp * temp;

		}

		return rv;
	}
}
