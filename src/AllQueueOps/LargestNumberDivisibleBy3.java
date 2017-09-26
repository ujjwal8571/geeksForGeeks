package AllQueueOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LargestNumberDivisibleBy3 {

	public static void main(String[] args) {
		
		int[] arr = {8, 9, 7, 6, 0};
		
		System.out.println(largestNumberDivBy3(arr));
	}

	public static int largestNumberDivBy3(int[] arr) {

		ArrayList<Integer> finalList = new ArrayList<>();

		LinkedList<Integer> rem1Queue = new LinkedList<>();
		LinkedList<Integer> rem2Queue = new LinkedList<>();

		Arrays.sort(arr);
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] % 3 == 0) {

				finalList.add(arr[i]);
			} else if (arr[i] % 3 == 1) {
				rem1Queue.addLast(arr[i]);

			} else {
				rem2Queue.addLast(arr[i]);
			}
		}

		if (sum % 3 == 0) {
			// nothing to do
		} else if (sum % 3 == 1) {
			if (rem1Queue.size() == 0) {

				if (rem2Queue.size() < 2) {
					return -1;
				} else {

					rem2Queue.removeFirst();
					rem2Queue.removeFirst();
				}

			} else {
				rem1Queue.removeFirst();
			}

		} else {

			if (rem2Queue.size() == 0) {
				if (rem1Queue.size() < 2) {
					return -1;
				} else {
					rem1Queue.removeFirst();
					rem1Queue.removeFirst();
				}
			} else {
				rem2Queue.removeFirst();
			}

		}

		while (!rem1Queue.isEmpty()) {
			finalList.add(rem1Queue.removeFirst());
		}

		while (!rem2Queue.isEmpty()) {
			finalList.add(rem2Queue.removeFirst());
		}

		Collections.sort(finalList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		int rv = 0;

		for (int val : finalList) {
			rv = rv * 10;
			rv += val;
		}

		return rv;

	}

}
