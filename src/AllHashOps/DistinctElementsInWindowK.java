package AllHashOps;

import java.util.HashMap;

public class DistinctElementsInWindowK {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
		printDistinctInWindow(arr, 4);
	}

	public static void printDistinctInWindow(int[] arr, int k) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < k; i++) {

			if (!hm.containsKey(arr[i])) {
				hm.put(arr[i], 0);
			}
			hm.put(arr[i], hm.get(arr[i]) + 1);

		}

		System.out.println(hm.size());

		for (int i = k; i < arr.length; i++) {

			hm.put(arr[i - k], hm.get(arr[i - k]) - 1);

			if (hm.get(arr[i - k]) == 0) {
				hm.remove(arr[i - k]);
			}

			if (!hm.containsKey(arr[i])) {
				hm.put(arr[i], 0);
			}
			hm.put(arr[i], hm.get(arr[i]) + 1);

			System.out.println(hm.size());
		}
	}

}
