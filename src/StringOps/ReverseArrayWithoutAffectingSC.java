package StringOps;

public class ReverseArrayWithoutAffectingSC {

	public static void main(String[] args) {

		String str = "a,b$c";
		System.out.println(reverseString(str));
	}

	public static String reverseString(String str) {
		String rv = "";
		int i = 0, j = str.length() - 1;
		while (i < str.length() && j >= 0) {
			int ascii = (int) str.charAt(i);
			if (ascii < 97 || ascii > 122) {
				System.out.println(str.charAt(i));
				rv += str.charAt(i);
				i++;
				continue;
			} else {
				rv += str.charAt(j);
				i++;
				j--;

			}
		}

		return rv;

	}

}
