package AllArrayOps.SearchingAndSorting;

public class FIndRepeatingAndMissing {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 6, 2, 1, 1 };
		findMissingAndRepeatingUsingIndexes(arr);
	}

	// public static void printMissingAndRepeating(int[] arr) {
	//
	// int repeating = 0;
	//
	// for (int i = 0; i < arr.length; i++) {
	// repeating = repeating ^ arr[i] ^ (i + 1);
	//
	// }
	//
	// System.out.println(repeating);
	// }

	public static void findMissingAndRepeatingUsingIndexes(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[arr[i] - 1] > 0) {
				arr[arr[i] - 1] *= -1;
			} else {
				System.out.println("extra number is " + arr[i]);
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				System.out.println("missing number is " + i);
			}
		}

	}

}
