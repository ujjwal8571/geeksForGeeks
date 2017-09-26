package AllHashOps;

import java.util.HashMap;
import java.util.Scanner;

public class LongestConsequtiveSubsequencce {

	public static void main(String[] args) {

		// int[] arr = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
		//
		// System.out.println(longestConsequtiveSs(arr));

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {

			int r = scn.nextInt();
			int[] arr = new int[r];

			for (int i = 0; i < arr.length; i++) {

				arr[i] = scn.nextInt();
			}

			System.out.println(longestConsequtiveSs(arr));

			t--;
		}
	}

	public static int longestConsequtiveSs(int[] arr) {
		int rv = 1;
		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int val : arr) {
			hm.put(val, true);
		}

		for (int val : arr) {

			if (hm.containsKey(val - 1)) {
				hm.put(val, false);
			}
		}

		for (int val : arr) {
			int cnt = 1;
			if (hm.get(val)) {
				int temp = val + 1;
				while (true) {
					if (hm.containsKey(temp)) {
						cnt++;
						temp++;
					} else {
						break;
					}
				}

				if (cnt > rv) {
					rv = cnt;
				}
			}

		}

		return rv;
	}

}
