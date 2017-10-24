package Algorithms.DynamicProgramming;

public class BreakNumIn3PartsToGetMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(breakNumIn3Parts(24));

	}

	public static int breakNumIn3Parts(int num) {

		int[] strg = new int[num + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {

			strg[i] = Math.max(i / 2, strg[i / 2]) + Math.max(i / 3, strg[i / 3]) + Math.max(i / 4, strg[i / 4]);
		}

//		for (int val : strg) {
//			System.out.print(val + ",  ");
//		}
//		System.out.println();

		return strg[num];
	}

}
