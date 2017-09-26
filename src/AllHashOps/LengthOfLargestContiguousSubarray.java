package AllHashOps;

import java.util.Arrays;
import java.util.HashMap;

public class LengthOfLargestContiguousSubarray {

	public static void main(String[] args) {

		int[] arr = { 1, 56, 58, 89, 57, 90, 92, 94, 93, 91, 96, 45, 95 };
		System.out.println(lengthOfLargestSa(arr));
	}

	public static int lengthOfLargestSa(int[] arr) {

		int[] tempArr = Arrays.copyOf(arr, arr.length);

		Arrays.sort(tempArr);
		int count = 0;

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int val : tempArr) {
			if (hm.containsKey(val - 1)) {
				hm.put(val, count);
			} else {
				count++;
				hm.put(val, count);
			}
		}

		// System.out.println(hm);

		int grpNo = hm.get(arr[0]);
		count = 0;
		int maxlen = 0;
		for (int val : arr) {
			if (hm.get(val) == grpNo) {
				count++;
			} else {

				grpNo = hm.get(val);

				if (count > maxlen) {
					maxlen = count;
				}
				count = 1;
			}

		}

		return maxlen;

	}

}
