package DataStructures.ArrayOps;

import java.util.Arrays;
import java.util.Comparator;

public class FormLargestNumber {

	public static void main(String[] args) {

		Integer[] arr = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(arr));
	}

	public static String largestNumber(Integer[] arr) {
		String rv = "";

		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				Integer temp1 = 0, temp2 = 0;
				temp1 = Integer.valueOf(String.valueOf(o1) + String.valueOf(o2));
				temp2 = Integer.valueOf(String.valueOf(o2) + String.valueOf(o1));

				return temp2 - temp1;

			}
		});

		for (int val : arr) {
			rv += val;
		}
		return rv;

	}

}
