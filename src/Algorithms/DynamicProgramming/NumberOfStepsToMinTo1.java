package Algorithms.DynamicProgramming;

public class NumberOfStepsToMinTo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(stepsToMinTo1(10));
	}

	public static int stepsToMinTo1(int num) {
		int[] strg = new int[num + 1];

		strg[0] = Integer.MAX_VALUE;
		strg[1] = 0;

		for (int i = 2; i < strg.length; i++) {

			int minStep = i;

			if (i % 3 == 0 && strg[i / 3] < minStep) {
				minStep = strg[i / 3] + 1;
			}

			if (i % 2 == 0 && strg[i / 2] < minStep) {
				minStep = strg[i / 2] + 1;
			}

			if (strg[i - 1] < minStep) {

				minStep = strg[i - 1] + 1;
			}

			strg[i] = minStep;

		}

		// for (int val : strg) {
		// System.out.print(val + ", ");
		// }
		// System.out.println();

		return strg[num];
	}

}
