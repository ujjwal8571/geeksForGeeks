package StringOps;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(firstNonRepeatingChar("geeksffforgeeoks"));
	}

	public static char firstNonRepeatingChar(String str) {
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

		int minIdx = str.length();
		char rv = '.';
		for (Character key : keys) {

			pair p = hm.get(key);

			if (p.count == 1) {

				if (p.firstIdx < minIdx) {
					minIdx = p.firstIdx;
					rv = key;
				}
			}
		}

		return rv;

	}

	public static class pair {
		int count;
		int firstIdx;

		public pair(int count, int firstIdx) {
			this.count = count;
			this.firstIdx = firstIdx;
		}
	}
}
