package Algorithms.DynamicProgramming;

public class TIllingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(wayToTile2xnFloor(4));
	}

	public static int wayToTile2xnFloor(int n) {

		int[] strg = new int[n + 1];
		strg[0] = strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {

			strg[i] = strg[i - 1] + strg[i - 2];

		}

		return strg[n];
	}

}
