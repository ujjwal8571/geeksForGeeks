package DataStructures.HashingOps;

import java.util.HashMap;

public class ArrayHasDuplicatesInKDist {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 4};
		System.out.println(hasDuplicates(arr, 3));
	}

	public static boolean hasDuplicates(int[] arr, int k) {
		HashMap<Integer, Boolean> hm = new HashMap<>(); // val,index

		for (int i = 0; i < k; i++) {
			int val = arr[i];

			if (hm.containsKey(val)) {
				return true;
			}

			hm.put(val, true);
		}
		System.out.println(hm);

		for (int i = k; i < arr.length; i++) {

			int val = arr[i];

			if (hm.containsKey(val)) {
				return true;
			}
			hm.put(val, true);

			hm.remove(arr[i - k]);
			System.out.println(hm);

		}

		return false;

	}

}
