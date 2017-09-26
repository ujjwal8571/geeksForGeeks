package AllHashOps;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintSubArrayWithSum0 {

	public static void main(String[] args) {
		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };

		printSubArrayWithSum0(arr);

	}

	public static void printSubArrayWithSum0(int[] arr) {

		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		int sum = 0;

		// base for case when sum of entire array is also zero
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(-1);
		hm.put(0, temp);

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (hm.containsKey(sum)) {
				ArrayList<Integer> list = hm.get(sum);
				for (int idx : list) {
					System.out.println((idx + 1) + "--" + i);
				}
			}
			if (!hm.containsKey(sum)) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i);
				hm.put(sum, al);
			} else {
				ArrayList<Integer> al = hm.get(sum);
				al.add(i);
				hm.put(sum, al);
			}
		}
	}

}
