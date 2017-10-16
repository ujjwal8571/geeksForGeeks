package AllHashOps;

import java.util.PriorityQueue;

public class FIndMinRangeWith1ElementEach {

	public static void main(String[] args) {

		int[][] arr = { { 4, 7, 9, 12, 15 }, { 0, 8, 10, 14, 20 }, { 6, 12, 16, 30, 50 } };

		printMinRangeWithOneElementEachFromAllLists(arr);
	}

	public static class pair implements Comparable<pair> {
		int kthArr;
		int value;

		public pair(int k, int val) {
			this.kthArr = k;
			this.value = val;
		}

		@Override
		public int compareTo(pair o) {

			return this.value - o.value;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String str = this.kthArr + "," + this.value;
			return str;
		}
	}

	public static void printMinRangeWithOneElementEachFromAllLists(int[][] karr) {

		PriorityQueue<pair> pq = new PriorityQueue<>();

		int min = -1, max = -1;
		int[] pointers = new int[karr.length];

		for (int i = 0; i < pointers.length; i++) {

			int val = karr[i][pointers[i]];

			if (val > max) {
				max = val;
			}

			pair p = new pair(i, val);
			pq.add(p);

		}

		min = pq.peek().value;

		int rangeMin = min;
		int rangeMax = max;

		while (true) {

			pair p = pq.remove();

			int arrIdx = p.kthArr;

			pointers[arrIdx]++;

			if (pointers[arrIdx] == karr[0].length) {
				break;
			}

			int val = karr[arrIdx][pointers[arrIdx]];

			if (val > max) {
				max = val;
			}

			p = new pair(arrIdx, val);

			pq.add(p);
			min = pq.peek().value;

			if (max - min < rangeMax - rangeMin) {
				rangeMax = max;
				rangeMin = min;
			}

		}

		System.out.println(rangeMin + " -- " + rangeMax);

	}

}
