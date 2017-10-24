package StringOps;

import java.util.HashMap;
import java.util.HashSet;

public class CheckKAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String one = "geeks";
		String two = "eggkf";
		int k = 1;

		System.out.println(isKAnagran(one, two, k));

	}

	public static boolean isKAnagran(String one, String two, int k) {

		int[] count = new int[26];
		int[] count2 = new int[26];
		int diff = 0;

		if (one.length() != two.length()) {
			return false;
		}

		for (int i = 0; i < one.length(); i++) {
			char ch1 = one.charAt(i);
			char ch2 = two.charAt(i);

			count[ch1 - 'a']++;
			count2[ch2 - 'a']++;

		}

		for (int i = 0; i < count.length; i++) {

			if (count[i] > count2[i]) {
				diff += Math.abs(count[i] - count2[i]);
			}
		}

		return diff <= k;
	}

}
