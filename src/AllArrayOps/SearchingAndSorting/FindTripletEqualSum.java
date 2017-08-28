package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class FindTripletEqualSum {

	public static void main(String[] args) {
		int[] arr = { 12, 3, 4, 1, 6, 9 };
		System.out.println(findTripletWithSum(arr, 244));
	}

	public static boolean findTripletWithSum(int[] arr, int sum) {

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {

			int low = i + 1;
			int high = arr.length - 1;

			while (low < high) {
				int temp = arr[i] + arr[low] + arr[high];
				if (temp == sum) {
					System.out.println(arr[i] + ", " + arr[low] + ", " + arr[high]);
					return true;
				} else if (temp < sum) {
					low++;
				} else {
					high--;
				}
			}

		}
		return false;

	}

}
