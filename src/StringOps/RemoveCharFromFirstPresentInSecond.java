package StringOps;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveCharFromFirstPresentInSecond {

	public static void main(String[] args) {

		String one = "geeksforgeeks";
		String two = "mask";
		
		one = removeCharFromOne(one, two);
		System.out.println(one);
	}

	public static String removeCharFromOne(String one, String two) {

		HashSet<Character> hs = new HashSet<>();

		for (int i = 0; i < two.length(); i++) {

			hs.add(two.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < one.length(); i++) {

			char ch = one.charAt(i);

			if (!hs.contains(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
