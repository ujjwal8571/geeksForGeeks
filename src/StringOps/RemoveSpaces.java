package StringOps;

public class RemoveSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(removeSpaces("g  eeks   for ge  eeks  "));
	}

	public static String removeSpaces(String str) {

		StringBuilder sb = new StringBuilder();

		char temp = str.charAt(0);
		sb.append(temp);
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch != ' ') {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
