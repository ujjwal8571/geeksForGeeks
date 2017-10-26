package StringOps;

public class PrintAllPermutationsWithRep {
	public static void main(String[] args) {
		
		printAllPermutationsWithRep("abc", "");
	}

	public static void printAllPermutationsWithRep(String str, String ans) {

		if (ans.length() == str.length()) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			printAllPermutationsWithRep(str, ans + ch);
		}
	}
}
