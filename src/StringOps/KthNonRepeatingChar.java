package StringOps;

import java.util.ArrayList;
import java.util.Arrays;
	import java.util.HashMap;

public class KthNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(kthNonRepeatingChar("geeksforgeeks", 1));
	}

	public static char kthNonRepeatingChar(String str, int k) {

		HashMap<Character, pair> hm = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (!hm.containsKey(ch)) {

				hm.put(ch, new pair(1, i));
			} else {

				int oldCount = hm.get(ch).count;
				int idx = hm.get(ch).firstIdx;
				hm.put(ch, new pair(oldCount + 1, idx));
			}
		}

		ArrayList<Character> keys = new ArrayList<>(hm.keySet());

		for (Character key : keys) {
			if (hm.get(key).count > 1) {
				hm.remove(key);
			}
		}

		keys = new ArrayList<>(hm.keySet());

		pair[] p = new pair[hm.size()];

		for (int i = 0; i < keys.size(); i++) {

			p[i] = new pair(keys.get(i), hm.get(keys.get(i)).firstIdx);
		}

		Arrays.sort(p);

		if (p.length < k) {
			return '-';
		} else {
			return p[k - 1].ch;
		}
	}

	public static class pair implements Comparable<pair> {
		int count;
		int firstIdx;
		char ch;

		public pair(int count, int firstIdx) {
			this.count = count;
			this.firstIdx = firstIdx;
		}

		public pair(char ch, int idx) {
			this.ch = ch;
			this.firstIdx = idx;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.firstIdx - o.firstIdx;
		}

	}

}
