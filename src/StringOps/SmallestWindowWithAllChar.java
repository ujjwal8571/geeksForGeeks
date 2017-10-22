package StringOps;

import java.util.HashMap;

public class SmallestWindowWithAllChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String smallestWindow(String str, String pattern) {

		String rv = "";

		int areAllFound = 0;

		HashMap<Character, Boolean> hm = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {

			hm.put(pattern.charAt(i), false);
		}

		for (int i = 0; i < pattern.length(); i++) {

			char ch = str.charAt(i);
			
			
			
		}

		return rv;
	}

}
