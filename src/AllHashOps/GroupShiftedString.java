package AllHashOps;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupShiftedString {

	public static void main(String[] args) {
		String[] arr = { "acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs" };

		printGroupShiftedStrings(arr);

	}

	public static void printGroupShiftedStrings(String[] arr) {

		HashMap<String, ArrayList<String>> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];

			// creating ch diff
			String chDiff = "";

			for (int c = 1; c < str.length(); c++) {
				int temp = str.charAt(c) - str.charAt(c - 1);
				temp = (temp + 26) % 26;
				chDiff += temp;
			}

			if (hm.containsKey(chDiff)) {
				ArrayList<String> list = hm.get(chDiff);
				list.add(str);
				hm.put(chDiff, list);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				hm.put(chDiff, list);
			}
		}
		// System.out.println(hm);

		ArrayList<String> keys = new ArrayList<>(hm.keySet());

		for (String key : keys) {
			System.out.println(hm.get(key));
		}
	}
}
