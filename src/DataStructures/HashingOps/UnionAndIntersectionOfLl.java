package DataStructures.HashingOps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class UnionAndIntersectionOfLl {

	public static void main(String[] args) {

		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();

		list1.addLast(10);
		list1.addLast(15);
		list1.addLast(4);
		list1.addLast(20);

		list2.addLast(8);
		list2.addLast(4);
		list2.addLast(2);
		list2.addLast(10);

		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int i = 0; i < list1.size(); i++) {

			int val = list1.removeFirst();
			hm.put(val, false);
			list1.addLast(val);

		}

		for (int i = 0; i < list2.size(); i++) {

			int val = list2.removeFirst();

			if (hm.containsKey(val)) {
				hm.put(val, true);
			} else {
				hm.put(val, false);
			}

			list2.addLast(val);
		}

		LinkedList<Integer> intersection = new LinkedList<>();
		LinkedList<Integer> union = new LinkedList<>();
		Set<Integer> keys = hm.keySet();

		for (int key : keys) {
			if (hm.get(key)) {
				intersection.addFirst(key);
				union.addLast(key);
			} else {

				union.addLast(key);
			}
		}

		System.out.println(intersection);
		System.out.println(union);

	}

}
