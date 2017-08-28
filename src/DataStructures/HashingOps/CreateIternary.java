package DataStructures.HashingOps;

import java.util.HashMap;
import java.util.Set;

public class CreateIternary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> hm = new HashMap<>();

		hm.put("chennai", "bangalore");
		hm.put("bombay", "delhi");
		hm.put("goa", "chennai");
		hm.put("delhi", "goa");

		String start = findStartingPoint(hm);
		while (true) {
			String end = hm.get(start);

			if (end == null) {
				break;
			}

			System.out.println(start + "," + end);
			start = end;
		}

	}

	public static String findStartingPoint(HashMap<String, String> hm) {

		HashMap<String, String> reverseHm = new HashMap<>();

		Set<String> keys = hm.keySet();

		for (String key : keys) {
			reverseHm.put(hm.get(key), key);
		}

		for (String key : keys) {

			if (!reverseHm.containsKey(key)) {
				return key;
			}
		}

		return "";

	}

}
