package StringOps;

import java.util.ArrayList;
import java.util.HashMap;

public class SecondMostOccuring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(secondMostOccuringChar("geeksforggeeks"));

		}

	public static char secondMostOccuringChar(String str) {

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (!hm.containsKey(ch)) {
				hm.put(ch, 1);

			} else {
				hm.put(ch, hm.get(ch) + 1);
			}
		}

		ArrayList<Character> keys = new ArrayList<>(hm.keySet());
		System.out.println(hm);

		int maxFreq = -1;
		char rv = 'a';
		int secondMax = -1;
		for (Character key : keys) {
			int count = hm.get(key);

			if (count > maxFreq) {
				secondMax = maxFreq;
				maxFreq = count;

			} else if (count >= secondMax && count < maxFreq) {

				secondMax = count;
				rv = key;
			} else {

			}

		}
		return rv;
	}

}
