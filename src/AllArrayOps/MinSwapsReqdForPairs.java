package AllArrayOps;

import java.util.ArrayList;
import java.util.HashMap;

public class MinSwapsReqdForPairs {

	public static void main(String[] args) {
		int arr[] = { 3, 5, 6, 4, 1, 2 };

		// int pairs[] = { 0, 3, 6, 1, 5, 4, 2 };
		HashMap<Integer, Integer> hm = new HashMap<>();

		hm.put(1, 3);
		hm.put(2, 6);
		hm.put(4, 5);

		System.out.println(minSwapsRequired(arr, 0, hm));

	}

	public static int minSwapsRequired(int[] arr, int vidx, HashMap<Integer, Integer> pairs) {

		if (vidx >= arr.length - 1) {
			return 0;
		}

		int first = arr[vidx];
		int second = arr[vidx + 1];

		if (pairs.containsKey(first) || pairs.containsKey(second)) {
			return minSwapsRequired(arr, vidx + 1, pairs);
		}

		int pairOfFirst = findPairInHm(pairs, first);
		int pairOfSecond = findPairInHm(pairs, second);
		int idxFirstPair = findIdx(arr, pairOfFirst);
		int idxSecondPair = findIdx(arr, pairOfSecond);

		swap(arr, vidx, idxFirstPair);
		int recAns1 = minSwapsRequired(arr, vidx + 1, pairs);
		swap(arr, vidx, idxFirstPair);

		swap(arr, vidx + 1, idxSecondPair);
		int recAns2 = minSwapsRequired(arr, vidx + 1, pairs);
		swap(arr, vidx + 1, idxSecondPair);

		return Math.min(recAns1, recAns2) + 1;
	}

	public static int findPairInHm(HashMap<Integer, Integer> hm, int val) {

		if (hm.containsKey(val)) {
			return hm.get(val);
		}

		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

		for (int key : keys) {
			if (hm.get(key) == val) {
				return key;
			}
		}
		System.out.println(val);
		return -1;

	}

	// can be done in log n using binary search
	public static int findIdx(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				return i;
			}
		}

		return -1;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
