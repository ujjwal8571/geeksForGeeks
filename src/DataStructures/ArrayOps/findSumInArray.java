package DataStructures.ArrayOps;

import java.util.Arrays;
import java.util.HashMap;

public class findSumInArray {

	// http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/

	public static void main(String[] args) {

		int[] arr = { 1, 4, 45, 6, 10, -8 };
		System.out.println(findSumHm(arr, 16));
	}

	// using sorting
	// o(nlogn)
	public static boolean findSum(int[] arr, int tar) {

		Arrays.sort(arr);

		for (int i = 0, j = arr.length - 1; i < j;) {
			if (arr[i] + arr[j] == tar) {
				System.out.println(arr[i] + "," + arr[j]);
				return true;
			} else if (arr[i] + arr[j] > tar) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

	// using hashing
	// o(n)
	public static boolean findSumHm(int[] arr, int tar) {
		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int val : arr) {
			hm.put(val, true);
		}

		for (int val : arr) {
			if (hm.containsKey(tar - val)) {
				System.out.println(val + "," + (tar - val));
				return true;
			}
		}
		return false;
	}

}
