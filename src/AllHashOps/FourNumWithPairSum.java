package AllHashOps;

import java.util.HashMap;

public class FourNumWithPairSum {

	public static void main(String[] args) {

		int[] arr = { 3, 4, 7, 1, 2, 9, 8 };

		print4NumWithPairSum(arr);
	}

	public static class pair {
		int firstNum;
		int secondNum;

		public pair(int n1, int n2) {
			this.firstNum = n1;
			this.secondNum = n2;
		}
	}

	public static void print4NumWithPairSum(int[] arr) {

		HashMap<Integer, pair> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (!hm.containsKey(arr[i] + arr[j])) {
					hm.put(arr[i] + arr[j], new pair(arr[i], arr[j]));
				} else {

					pair p = hm.get(arr[i] + arr[j]);
					System.out.println(arr[i] + "," + arr[j] + "," + p.firstNum + "," + p.secondNum);
				}
			}
		}

	}

}
