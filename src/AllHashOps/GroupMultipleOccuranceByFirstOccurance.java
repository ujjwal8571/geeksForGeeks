package AllHashOps;

import java.util.HashMap;

public class GroupMultipleOccuranceByFirstOccurance {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 9, 2, 3, 4, 9, 6, 10, 4 };

		int[] ans = groupByOccPrefOrder(arr);

		for (int val : ans) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static int[] groupByOccPrefOrder(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int val : arr) {

			if (hm.containsKey(val)) {
				hm.put(val, hm.get(val) + 1);
			} else {
				hm.put(val, 1);
			}
		}

		int[] rv = new int[arr.length];
		int idx = 0;

		for (int val : arr) {

			if (hm.containsKey(val)) {

				for (int i = 0; i < hm.get(val); i++) {
					rv[idx] = val;
					idx++;
				}
				hm.remove(val);
			}

		}

		return rv;
	}

}
