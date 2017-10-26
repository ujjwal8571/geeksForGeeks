package StringOps;

import java.util.Collections;
import java.util.PriorityQueue;

public class RearrangeStringstAllCharKDistApart {
	public static void main(String[] args) {

		System.out.println(rearrangeStringstAllCharKDistApart("aacbbc", 3));
	}

	public static String rearrangeStringstAllCharKDistApart(String str, int k) {

		PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] freq = new int[26];

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			freq[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {

				pq.add(new pair((char) ('a' + i), freq[i]));
			}
		}

		char[] charArr = new char[str.length()];

		while (!pq.isEmpty()) {
			pair p = pq.remove();

			int fns = findForstNullSpot(charArr);
			for (int i = 0; i < p.freq; i++) {
				charArr[fns] = p.ch;
				fns = (fns + k) % str.length();
			}
		}
		
		return String.valueOf(charArr);

	}

	private static int findForstNullSpot(char[] charArr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < charArr.length; i++) {

			if (charArr[i] == '\0') {
				return i;
			}
		}

		return -1;
	}

	public static class pair implements Comparable<pair> {
		char ch;
		int freq;

		public pair(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}

	}
}
