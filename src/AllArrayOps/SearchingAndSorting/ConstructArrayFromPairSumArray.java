package AllArrayOps.SearchingAndSorting;


import AllArrayOps.ArrayBasic;

public class ConstructArrayFromPairSumArray extends ArrayBasic {

	public static void main(String[] args) {
		int[] pair = { 14, 9, 10, 11, 12, 7 };
		int[] arr = constructArrayFromPairSum(pair);

		display(arr);
	}

	public static int[] constructArrayFromPairSum(int[] pair) {
		int[] arr = new int[findLengthOfArray(pair)];

		arr[0] = (pair[0] + pair[1] - pair[arr.length - 1]) / 2;
		int ctr = arr.length - 1;
		int idx = 1;

		for (int i = 0; i < ctr && i < pair.length; i++) {
			arr[idx] = pair[i] - arr[0];
			idx++;
		}

		return arr;
	}

	public static int findLengthOfArray(int[] pair) {
		int length = 0;

		length = (1 + (int) (Math.sqrt(1 + 8 * pair.length)) / 2);

		return length;
	}

}
