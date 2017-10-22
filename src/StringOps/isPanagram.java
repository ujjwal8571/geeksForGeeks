package StringOps;

public class isPanagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = " The quick brown fox jumps over the dog ";
		System.out.println(isPanagram(str));
	}

	public static boolean isPanagram(String str) {

		boolean[] strg = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == ' ') {
				continue;
			}

			if (Character.isUpperCase(ch)) {

				strg[ch - 'A'] = true;
			} else {
				strg[ch - 'a'] = true;
			}
		}

		for (boolean val : strg) {

			if (val == false) {
				return false;
			}
		}

		return true;

	}
}
