package AllArrayOps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortByDefinedOrderPreference {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int[] order = { 2, 1, 8, 3 };

		arr = sortByOrder(arr, order);

		for (int val : arr) {
			System.out.print(val + ", ");
		}

	}

	public static int[] sortByOrder(int[] arr, int[] order) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (hm.containsKey(arr[i])) {

				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else {
				hm.put(arr[i], 1);

			}

		}

		int[] rv = new int[arr.length];
		int idx = 0;

		for (int i = 0; i < order.length; i++) {
			int val = order[i];

			int freq = hm.remove(val);

			for (int k = 0; k < freq; k++) {
				rv[idx] = val;
				idx++;
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());
		Collections.sort(keys);

		for (int key : keys) {
			rv[idx] = key;
			idx++;

		}
		return rv;

	}

}
