package AllArrayOps.SearchingAndSorting;

public class CountFreqOfElementInOn {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 2, 5 };
		printFreq(arr);
	}

	public static void printFreq(int[] arr) {

		int i = 0;
		while (i < arr.length) {

			if (arr[i] < 0) {
				i++;
				continue;
			}

			int idx = arr[i] - 1;

			if (arr[idx] > 0) {
				arr[i] = arr[idx];
				arr[idx] = -1;
			} else {
				arr[idx]--;
				arr[i] = 0;
				i++;
			}
		}

		for (int j = 0; j < arr.length; j++) {
			System.out.println(j + 1 + " => " + -1 * arr[j]);
		}
	}

}
