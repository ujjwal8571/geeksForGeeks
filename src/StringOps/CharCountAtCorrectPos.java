package StringOps;

public class CharCountAtCorrectPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(charCountAtCorrectPos("ABcED"));

		// System.out.println('A' - 'A' + "," + 'A' + 0);
	}

	public static int charCountAtCorrectPos(String str) {

		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {

				if (ch - 'A' == i) {
					cnt++;
				}

			} else {

				if (ch - 'a' == i) {
					cnt++;
				}

			}

		}

		return cnt;
	}
}
