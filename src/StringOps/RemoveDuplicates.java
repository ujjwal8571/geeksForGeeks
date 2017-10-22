package StringOps;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(removeDuplicates("geekkssfoorgeeks"));
	}

	public static String removeDuplicates(String str) {

		StringBuilder sb = new StringBuilder();

		char temp = str.charAt(0);
		sb.append(temp);
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == temp) {

			} else {
				sb.append(ch);
				temp = ch;
			}
		}

		return sb.toString();
	}
}
