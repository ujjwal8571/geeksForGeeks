package AllArrayOps.SearchingAndSorting;

import java.util.HashSet;

public class DuplicateWithinKDist {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 4, 1, 2, 3, 4 };
		System.out.println(isDuplicatePresentInKDist(arr, 3));
	}

	public static boolean isDuplicatePresentInKDist(int[] arr, int k) {
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < k; i++) {

			if (hs.contains(arr[i])) {
				return true;
			} else {
				hs.add(arr[i]);
			}

		}

		for (int i = k; i < arr.length; i++) {

			hs.remove(arr[i - k]);

			if (hs.contains(arr[i])) {
				return true;
			} else {
				hs.add(arr[i]);
			}

		}
		return false;
	}

}
