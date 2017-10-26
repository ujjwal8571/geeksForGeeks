package StringOps;

public class CheckStringCanBeRearrangedToPalindrome {

	public static void main(String[] args) {

		System.out.println(canStringBeRearrangedForPali("geeksforgeeks"));
	}

	public static boolean canStringBeRearrangedForPali(String str) {

		int[] freq = new int[26];

		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}

		int oddCnt = 0;

		for (int i = 0; i < 26; i++) {
			if (freq[i] % 2 == 1) {
				oddCnt++;
			}
		}
		System.out.println(oddCnt);

		if (str.length() % 2 == 0) {

			return oddCnt == 0;
		} else {

			return oddCnt == 1;
		}
	}
}
