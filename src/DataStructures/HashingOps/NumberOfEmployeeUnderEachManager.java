package DataStructures.HashingOps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class NumberOfEmployeeUnderEachManager {

	public static void main(String[] args) {

		HashMap<Character, Character> hm = new HashMap<>();

		hm.put('A', 'C');
		hm.put('B', 'C');
		hm.put('C', 'F');
		hm.put('D', 'E');
		hm.put('E', 'F');
		hm.put('F', 'F');

		findCount(hm);

	}

	public static void findCount(HashMap<Character, Character> hm) {
		HashMap<Character, ArrayList<Character>> counts = new HashMap<>();

		Set<Character> keys = hm.keySet();

		for (Character key : keys) {

			Character manager = hm.get(key);

			if (manager != key) {
				if (counts.containsKey(manager)) {

					ArrayList<Character> list = counts.get(manager);
					list.add(key);
				} else {

					ArrayList<Character> list = new ArrayList<>();
					list.add(key);
					counts.put(manager, list);
				}
			}

		}
		System.out.println(counts);
		HashMap<Character, Integer> result = new HashMap<>();
		for (Character key : keys) {
			getFinalResult(key, counts, result);
		}

		System.out.println(result);

	}

	public static int getFinalResult(Character manager, HashMap<Character, ArrayList<Character>> employeeDu,
			HashMap<Character, Integer> result) {

		int count = 0;

		if (employeeDu.containsKey(manager) == false) {
			result.put(manager, 0);
			return 0;
		}

		if (result.containsKey(manager)) {
			count = result.get(manager);
		} else {

			count = employeeDu.get(manager).size();
			ArrayList<Character> list = employeeDu.get(manager);

			for (int i = 0; i < list.size(); i++) {
				count += getFinalResult(list.get(i), employeeDu, result);
			}

			result.put(manager, count);

		}

		return count;

	}

}
