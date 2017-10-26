package StringOps;

public class PrintAllCommonCharInLexiOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String one = "geeks";
		String two = "forgeeks";

		printCommonChar(one, two);
	}

	public static void printCommonChar(String one, String two) {

		int[] arr1 = new int[26];
		int[] arr2 = new int[26];

		for (int i = 0; i < one.length(); i++) {
			char ch = one.charAt(i);

			arr1[ch - 'a']++;
		}

		for (int i = 0; i < two.length(); i++) {
			char ch = two.charAt(i);

			arr2[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++) {

			if (arr1[i] > 0 && arr2[i] > 0) {

				for (int j = 0; j < Math.min(arr1[i], arr2[i]); j++) {
					System.out.print((char) ('a' + i));
				}
			}
		}

	}
}
