package AllHashOps;

import java.util.ArrayList;
import java.util.HashMap;

public class DsWithGetRandom {

	public static void main(String[] args) {

		myDs ds = new myDs();
		ds.insert(10);
		ds.insert(30);
		ds.insert(50);
		ds.insert(20);
		ds.insert(70);
		ds.insert(50);

		System.out.println(ds.delete(50));
		System.out.println(ds.delete(100));

		System.out.println(ds.getRandom());
		System.out.println(ds.search(10));

	}

	public static class myDs {

		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		public void insert(int data) {

			list.add(data);
			int idx = list.size() - 1;
			hm.put(data, idx);
		}

		public int delete(int data) {
			if (!hm.containsKey(data)) {
				return -1;
			}

			int idx = hm.get(data);
			hm.remove(data);

			int temp = list.get(idx);
			list.set(idx, list.get(list.size() - 1));
			list.set(list.size() - 1, temp);
			list.remove(list.size() - 1);

			return temp;
		}

		public boolean search(int data) {
			return hm.containsKey(data);

		}

		public int getRandom() {

			int rand = (int) (Math.random() * list.size());

			return list.get(rand);
		}
	}

}
