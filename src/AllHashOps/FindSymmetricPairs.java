package AllHashOps;

import java.util.HashMap;

public class FindSymmetricPairs {

	public static void main(String[] args) {
		pair[] arr = new pair[5];
		arr[0] = new pair(11, 20);
		arr[1] = new pair(30, 40);
		arr[2] = new pair(5, 10);
		arr[3] = new pair(40, 30);
		arr[4] = new pair(10, 5);

		printSymmetricPairs(arr);
	}

	public static class pair {
		int val1;
		int val2;

		public pair(int one, int two) {
			this.val1 = one;
			this.val2 = two;
		}
	}

	public static void printSymmetricPairs(pair[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (pair p : arr) {
			hm.put(p.val2, p.val1);
		}

		for (pair p : arr) {

			if (hm.containsKey(p.val1)) {
				if (p.val2 == hm.get(p.val1)) {
					System.out.println(p.val1 + "," + p.val2);
					hm.remove(p.val1);
					hm.remove(p.val2);
				}

			}
		}
	}

}
