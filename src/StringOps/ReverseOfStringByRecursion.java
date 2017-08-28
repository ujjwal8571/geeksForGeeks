package StringOps;

public class ReverseOfStringByRecursion {

	public static void main(String[] args) {

		String str = "helloworld";
		printString(str, 0);
		System.out.println();
		System.out.println(str);
		printString(str);
		System.out.println();
		System.out.println(str);

	}

	// method 1
	public static void printString(String str, int idx) {
		if (idx == str.length()) {
			return;
		}
		printString(str, idx + 1);
		System.out.print(str.charAt(idx));

	}

	// method 2
	public static void printString(String str) {

		if (str.length() == 0) {
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		printString(ros);
		System.out.print(ch);

	}
}
