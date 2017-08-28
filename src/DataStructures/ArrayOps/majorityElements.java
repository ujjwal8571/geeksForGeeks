package DataStructures.ArrayOps;

import java.util.ArrayList;
import java.util.HashMap;

public class majorityElements {
	// http://www.geeksforgeeks.org/majority-element/
	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 2, 5, 5, 2, 3, 3 };
		System.out.println(majorityElement(arr));
	}

	public static int majorityElement(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int val : arr) {
			if (hm.containsKey(val)) {
				hm.put(val, hm.get(val) + 1);
			} else {
				hm.put(val, 1);
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

		int reqdFreq = arr.length / 2;
		for (int key : keys) {
			if (hm.get(key) > reqdFreq) {
				return key;
			}
		}

		return -1;
	}

}
