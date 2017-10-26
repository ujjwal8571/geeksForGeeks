package StringOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupWordsWithSameSetChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String words[] = { "may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat",
				"flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle" };

		groupWordsWithSameSetChar2(words);
	}

	// n*klogk approach
	public static void groupWordsWithSameSetChar(String[] arr) {

		HashMap<String, ArrayList<String>> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];

			char[] tempArr = str.toCharArray();
			Arrays.sort(tempArr);

			String temp = new String(tempArr);
			if (hm.containsKey(temp)) {

				ArrayList<String> list = hm.get(temp);
				list.add(str);
				hm.put(temp, list);

			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				hm.put(temp, list);
			}

		}

		ArrayList<String> keys = new ArrayList<>(hm.keySet());

		for (String key : keys) {
			System.out.println(hm.get(key));
		}

	}

	// nlogk approach
	public static void groupWordsWithSameSetChar2(String[] arr) {

		HashMap<String, ArrayList<String>> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];

			String temp = getUniqueKey(str);
			if (hm.containsKey(temp)) {

				ArrayList<String> list = hm.get(temp);
				list.add(str);
				hm.put(temp, list);

			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				hm.put(temp, list);
			}

		}

		ArrayList<String> keys = new ArrayList<>(hm.keySet());

		for (String key : keys) {
			System.out.println(hm.get(key));
		}

	}

	private static String getUniqueKey(String str) {
		boolean[] isCharPresent = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {
				isCharPresent[ch - 'A'] = true;
			} else {
				isCharPresent[ch - 'a'] = true;
			}
		}

		String rv = "";

		for (int i = 0; i < 26; i++) {

			if (isCharPresent[i]) {
				rv += (char) ('a' + i);
			}
		}

		return rv;
	}

}
