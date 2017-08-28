package AllArrayOps;

public class printPattern {

	public static void main(String[] args) {
		int n = 4;
		int len = 2 * n - 1;
		int decInThisLine = 0;
		int val = n;
		for (int i = 0; i < len; i++) {

			val = n;
			int printSameCtr = len - (2 * decInThisLine);

			for (int k = 0; k < decInThisLine; k++) {

				System.out.print(val + " ");
				val--;

			}

			for (int k = 0; k < printSameCtr; k++) {
				System.out.print(val + " ");
			}
			val++;

			for (int k = 0; k < decInThisLine; k++) {

				System.out.print(val + " ");
				val++;

			}

			System.out.println();
			if (i < n - 1) {
				decInThisLine++;
			} else {
				decInThisLine--;
			}
		}

	}

}
