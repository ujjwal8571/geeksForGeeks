package AllHashOps;

import java.util.HashMap;
import java.util.Scanner;

public class CheckPalindromeForQqueries {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		int idx1 = -1, idx2 = -1;
		char ch;
		int numberOfMismatch = 0;

		HashMap<Integer, Character> hm = new HashMap<>();
		for (int i = 0; i < str.length() / 2; i++) {

			// filling the hashmap
			hm.put(i, str.charAt(i));
			hm.put(str.length() - i - 1, str.charAt(str.length() - 1 - i));

			// count initial number of mismatches
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				numberOfMismatch++;
			}

		}
		int q = scn.nextInt();
		scn.nextLine();

		for (int i = 0; i < q; i++) {
			idx1 = scn.nextInt();
			idx2 = scn.nextInt();
			ch = scn.next().charAt(0);
			scn.nextLine();

			// finding counter idx
			int idx1other = str.length() - idx1 - 1;
			int idx2other = str.length() - idx2 - 1;

			// checking for both indexes

			// for index1

			if (hm.get(idx1) != hm.get(idx1other)) { // pehle se hi galat the

				hm.put(idx1, ch);

				if (hm.get(idx1) != hm.get(idx1other)) { // ab bhi galat hai
					// do nothing
				} else {
					numberOfMismatch--;
				}

			} else { // pehle sahi the
				hm.put(idx1, ch);

				if (hm.get(idx1) != hm.get(idx1other)) { // ab bhi galat hai
					numberOfMismatch++;
				} else {
					// do nothing
				}
			}

			// for index 2

			if (hm.get(idx2) != hm.get(idx2other)) { // pehle se hi galat the

				hm.put(idx2, ch);

				if (hm.get(idx2) != hm.get(idx2other)) { // ab bhi galat hai
					// do nothing
				} else {
					numberOfMismatch--;
				}

			} else { // pehle sahi the
				hm.put(idx2, ch);

				if (hm.get(idx2) != hm.get(idx2other)) { // ab bhi galat hai
					numberOfMismatch++;
				} else {
					// do nothing
				}
			}

			if (numberOfMismatch == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}

}
