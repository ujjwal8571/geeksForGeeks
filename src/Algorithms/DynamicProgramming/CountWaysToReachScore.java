package Algorithms.DynamicProgramming;

public class CountWaysToReachScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(waysToReachScore2(20));
	}

	// player can score only 3/5/10

	// this counts all different permutations as distinct
	public static int waysToReachScore(int scr) {

		int[] strg = new int[scr + 1];

		strg[0] = 1;
		// strg[1] = 0;
		// strg[2] = 0;
		// strg[3] = 1;
		// strg[4] = 0;
		// strg[5] = 1;

		for (int i = 1; i < strg.length; i++) {

			int temp = 0;

			if (i - 3 >= 0) {
				temp += strg[i - 3];
			}

			if (i - 5 >= 0) {
				temp += strg[i - 5];
			}

			if (i - 10 >= 0) {
				temp += strg[i - 10];
			}

			strg[i] = temp;
			System.out.println(i + "," + strg[i]);
		}

		return strg[scr];
	}

	// this ignores permutations
	public static int waysToReachScore2(int scr) {

		int[] strg = new int[scr + 1];

		strg[0] = 1;
		// strg[1] = 0;
		// strg[2] = 0;
		// strg[3] = 1;
		// strg[4] = 0;
		// strg[5] = 1;

		for (int i = 3; i <= scr; i += 3) {
			strg[i] += strg[i - 3];
		}
		
		for (int i = 5; i <= scr; i += 5) {
			strg[i] += strg[i - 5];
		}
		
		for (int i = 10; i <= scr; i += 10) {
			strg[i] += strg[i - 10];
		}

		return strg[scr];
	}

}
