package AllArrayOps.SearchingAndSorting;

import java.util.HashMap;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		int[] arr = {10, 5, 3, 4, 3, 5, 6};
		System.out.println(firstRepeatingElement(arr));

	}

	public static int firstRepeatingElement(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int val : arr) {

			if (hm.containsKey(val)) {
				hm.put(val, hm.get(val) + 1);
			} else {
				hm.put(val, 1);
			}

		}

		for (int val : arr) {
			if (hm.get(val) > 1) {
				return val;
			}
		}

		return -1;
	}
}
