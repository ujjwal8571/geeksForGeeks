package StringOps;

public class CountSsWithSameFrstLastLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countSsWithSameFrstLastLetter2("aba"));
	}

	// o(n2) approach
	public static int countSsWithSameFrstLastLetter(String str) {

		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char chAti = str.charAt(i);
			for (int j = i; j < str.length(); j++) {
				char chAtj = str.charAt(j);

				if (chAti == chAtj) {
					cnt++;
				}

			}
		}

		return cnt;

	}

	// o(n) approach

	public static int countSsWithSameFrstLastLetter2(String str) {

		int[] strg = new int[26];

		for (int i = 0; i < str.length(); i++) {
			strg[str.charAt(i) - 'a']++;
		}

		int cnt = 0;
		for (int i = 0; i < 26; i++) {

			cnt += (strg[i] * (strg[i] + 1)) / 2;
		}

		return cnt;

	}

}
