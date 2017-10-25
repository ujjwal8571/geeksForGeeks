package Algorithms.DynamicProgramming;

import java.util.ArrayList;

public class PrintAllSubsetsWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, 4, 5 };
		int sum = 10;

		subsetSumProblem(arr, sum);
	}

	public static void printAllSubSets(boolean[][] strg, int[] arr, int sum, int i, int j, ArrayList<Integer> list) {

		
		
		// if we still get the result by excluding this number
		if (strg[i][j - 1]) {

			ArrayList<Integer> cpy = new ArrayList<>();
			cpy.addAll(list);
			printAllSubSets(strg, arr, sum, i, j - 1, cpy);

		}

		// we want to include this number to our result
		if (sum > arr[j - 1] && strg[i - arr[j - 1]][j - 1]) {

			list.add(arr[j - 1]);
			printAllSubSets(strg, arr, sum, i - arr[j - 1], j - 1, list);

		}
	}

	public static void subsetSumProblem(int[] arr, int sum) {

		boolean[][] strg = new boolean[sum + 1][arr.length + 1];

		for (int i = 0; i < strg.length; i++) {
			strg[i][0] = true;
		}

		for (int i = 1; i < strg.length; i++) {

			for (int j = 1; j < strg[0].length; j++) {

				strg[i][j] = strg[i][j - 1];

				if (arr[j - 1] <= i) {

					strg[i][j] = strg[i][j] || strg[i - arr[j - 1]][j - 1];
				}

			}
		}

		System.out.println(strg[sum][arr.length]);
		printAllSubSets(strg, arr, sum, arr.length, new ArrayList<>());

	}

}
