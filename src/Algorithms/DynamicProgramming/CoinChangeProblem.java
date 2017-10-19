package Algorithms.DynamicProgramming;

import java.util.Scanner;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// int[] coins = { 2, 5, 3, 6 };
		// int sum = 10;
		// System.out.println(coinChangeProblem(coins, sum));

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {

			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int sum = scn.nextInt();
			System.out.println(coinChangeProblem(arr, sum));
		}

	}

	public static int coinChangeProblem(int[] coins, int sum) {

		int[] strg = new int[sum + 1];

		strg[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];

			for (int j = coin; j < strg.length; j++) {

				int strgVal = strg[j];
				strg[j] = strg[j] + strg[j - coin];
			}
		}

		return strg[sum];
	}
}
