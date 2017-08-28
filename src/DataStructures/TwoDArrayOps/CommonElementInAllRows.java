package TwoDArrayOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElementInAllRows {

	// http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 }, };

		System.out.println(findCommonElement(mat));
		System.out.println(findCommonElementMergeSort(mat));

	}

	public static int findCommonElement(int[][] arr) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int j = 0; j < arr[0].length; j++) {
			hm.put(arr[0][j], 1);
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int num = arr[i][j];
				if (hm.containsKey(num)) {

					hm.put(num, hm.get(num) + 1);

				}

			}
		}

		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

		for (int key : keys) {
			if (hm.get(key) == arr.length) {
				return key;
			}

		}

		return -1;
	}

	public static int findCommonElementMergeSort(int[][] arr) {

		int[] colIdx = new int[arr.length];
		Arrays.fill(colIdx, arr[0].length - 1);

		while (true) {
			int tempAns = areAllElementsEqual(arr, colIdx);
			if (tempAns == -1) {
				updateColIdx(arr, colIdx);

			} else if (tempAns == -1) {
				break;

			} else {

				return tempAns;
			}

		}

		return -1;
	}

	public static int areAllElementsEqual(int[][] arr, int[] colIdx) {
		int val = arr[0][colIdx[0]];

		for (int i = 1; i < arr.length; i++) {

			if (colIdx[i] < 0) {
				return -2; // marks no answer
			}

			if (arr[i][colIdx[i]] != val) {
				return -1;
			}
		}
		return val;

	}

	public static void updateColIdx(int[][] arr, int[] colIdx) {

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < colIdx.length; i++) {
			if (arr[i][colIdx[i]] < min) {
				min = arr[i][colIdx[i]];
			}
		}

		for (int i = 0; i < colIdx.length; i++) {
			if (arr[i][colIdx[i]] != min) {
				colIdx[i]--;
			}

		}

	}
}
