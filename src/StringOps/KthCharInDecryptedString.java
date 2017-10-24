package StringOps;

public class KthCharInDecryptedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(kThCharInString("ab4c2ed3", 4));

		// String temp ="";
		// int t = Integer.parseInt(temp);
		// System.out.println(t);
	}

	public static char kThCharInString(String str, int k) {

		char rv = '.';

		int i = 0;
		int count = 0;
		while (i < str.length()) {

			String ch = "" + str.charAt(i);
			i++;

			while (i < str.length() && str.charAt(i) > 65) {
				ch += str.charAt(i);
				i++;
			}

			String numCnt = "";

			while (i < str.length() && str.charAt(i) < 65) {

				numCnt += str.charAt(i);
				i++;
			}

			if (numCnt.length() > 0) {

				int oldCnt = count;
				int charCnt = Integer.parseInt(numCnt);
				count += charCnt * ch.length();

				if (count >= k) {
					int temp = k - oldCnt;
					int rvIdx = (	temp - 1) % ch.length();
					return ch.charAt(rvIdx);

				}
			}

		}

		return rv;

	}

}
