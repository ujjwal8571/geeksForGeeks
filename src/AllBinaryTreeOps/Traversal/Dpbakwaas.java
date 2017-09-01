package AllBinaryTreeOps.Traversal;

import java.util.Scanner;

public class Dpbakwaas {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		// while (t > 0) {
		//
		// int n = scn.nextInt();
		// int[][] arr = new int[n][3];
		//
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < 3; j++) {
		// arr[i][j] = scn.nextInt();
		// }
		// }
		//
		// System.out.println(findMinCost(arr));
		//
		// t--;
		// }

		while (t > 0) {

			int n = scn.nextInt();

			int[] b = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				b[i] = scn.nextInt();

				if (b[i] > max) {
					max = b[i];
				}
			}

			int[][] arr = new int[max + 1][b.length];
			System.out.println(findMaxSumDiffType(arr, b));
			t--;
		}

	}

	public static int findMinCost(int[][] arr) {

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < arr[0].length; j++) {

				int idx1 = (j + 1) % 3;
				int idx2 = (j + 2) % 3;

				arr[i][j] = arr[i][j] + Math.min(arr[i - 1][idx1], arr[i - 1][idx2]);

			}

		}

		return Math.min(arr[arr.length - 1][0], Math.min(arr[arr.length - 1][1], arr[arr.length - 1][2]));
	}

	public static int findMaxSumDiffType(int[][] arr, int[] b) {

		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = 0;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {

				int cost1 = arr[1][j - 1] + Math.abs(i - arr[1][j - 1]);
				int cost2 = arr[b[j - 1]][j - 1] + Math.abs(i - arr[b[j - 1]][j - 1]);

				arr[i][j] = Math.max(cost1, cost2);

			}
		}

		int rv = Math.max(arr[b[b.length - 1]][arr[0].length - 1], arr[1][arr[0].length - 1]);

		return rv;
	}
}
