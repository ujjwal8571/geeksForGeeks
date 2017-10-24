package StringOps;

import java.util.ArrayList;

public class WordCount {

	public static void main(String[] args) {

		int[] costArr = { 20, 10, 4, 50, 100 };
		System.out.println(minCostToFillBag(costArr, 5));
	}

	public static int minCostToFillBag(int[] costArr, int maxWeight) {

		ArrayList<Integer> wts = new ArrayList<>();
		ArrayList<Integer> costs = new ArrayList<>();
		int numberOfPackets = 0;

		// this is just to handle to case when bag of a size is unavailable
		for (int i = 0; i < costArr.length; i++) {

			if (costArr[i] != -1) {

				wts.add(i + 1);
				costs.add(costArr[i]);
				numberOfPackets++;
			}
		}

		int[][] minCost = new int[numberOfPackets + 1][maxWeight + 1];

		for (int i = 0; i < minCost[0].length; i++) {
			minCost[0][i] = 1000;
		}

		for (int i = 0; i < minCost.length; i++) {
			minCost[i][0] = 0;
		}

		// System.out.println(wts);
		// System.out.println(costs);

		for (int i = 1; i < minCost.length; i++) {
			for (int j = 1; j < minCost[0].length; j++) {

				if (wts.get(i - 1) <= j) {
					// System.out.println(minCost[i - 1][j] + "," + (minCost[i][j - wts.get(i - 1)]
					// + costs.get(i - 1)));
					minCost[i][j] = Math.min(minCost[i - 1][j], minCost[i][j - wts.get(i - 1)] + costs.get(i - 1));

				} else {
					minCost[i][j] = minCost[i - 1][j];
				}

			}
		}

		// for (int i = 0; i < minCost.length; i++) {
		// for (int j = 0; j < minCost[0].length; j++) {
		//
		// System.out.print(minCost[i][j] + "\t");
		// }
		// System.out.println();
		// }
		return minCost[numberOfPackets][maxWeight];
	}
}
