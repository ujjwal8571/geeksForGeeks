package Algorithms.DynamicProgramming;

public class CuttingRodProblem {

	public static void main(String[] args) {
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };

		System.out.println(cuttingRodProblem(prices, prices.length));

	}

	public static int cuttingRodProblem(int[] prices, int length) {

		int[] strg = new int[length + 1];

		strg[0] = 0;

		for (int i = 1; i < strg.length; i++) {

			strg[i] = prices[i - 1];
			int start = 0, end = i;

			while (start <= end) {
				int tempMax = strg[start] + strg[end];

				if (tempMax > strg[i]) {
					strg[i] = tempMax;
				}

				start++;
				end--;
			}
		}

		return strg[length];
	}

}
