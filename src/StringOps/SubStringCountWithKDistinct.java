package StringOps;

import java.util.HashSet;

public class SubStringCountWithKDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ssWithKDistinctChar("aa", 1));
	}

	public static int ssWithKDistinctChar(String str, int k) {

		int count = 0;

		HashSet<Character> hs = new HashSet<>();

		for (int i = 0; i < str.length() - k + 1; i++) {

			hs = new HashSet<>();
			for (int j = i; j < str.length(); j++) {

				hs.add(str.charAt(j));

				if (hs.size() == k) {
					count++;
				}
			}

		}

		return count;
	}

}
