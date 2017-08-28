package DataStructures.HashingOps;

import java.util.HashMap;

public class ArraySubsetOFOther {

	public static void main(String[] args) {
		int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};
        
        System.out.println(findIfSubset(arr1, arr2));
	}

	public static boolean findIfSubset(int[] myArr, int[] other) {

		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int i = 0; i < myArr.length; i++) {
			hm.put(myArr[i], true);
		}

		for (int i = 0; i < other.length; i++) {
			if (hm.containsKey(other[i]) == false) {
				return false;
			}
		}

		return true;

	}

}
