package StringOps;

import java.util.Arrays;

public class PrintListItemsContainingAllLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pat = "sun";
		String[] arr = { "geeksforgeeks", "unsorted", "sunday", "just", "sss" };

		printItemsWithLetters(arr, pat);
	}

	public static void printItemsWithLetters(String[] arr, String pat) {

		int[] freq = new int[26];

		// o(len of pat)
		for (int i = 0; i < pat.length(); i++) {
			char ch = pat.charAt(i);
			freq[ch - 'a']++;
		}

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];

			// o(1)
			int[] copy = Arrays.copyOf(freq, freq.length);

			// o(len of word)
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);

				if (freq[ch - 'a'] != 0)
					copy[ch - 'a']--;
			}

			boolean flag = true;
			// o(1)
			for (int j = 0; j < 26; j++) {
				if (copy[j] > 0) {
					flag = false;
				}
			}

			if (flag) {
				System.out.println(arr[i]);
			}

		}

	}

}
