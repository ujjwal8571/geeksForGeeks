package TwoDArrayOps;

public class SumOfSubSquareKxK {

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4 },
				{ 5, 5, 5, 5, 5 }, };

		printSumOfSubSquare(mat, 3);
	}

	public static void display(int[][] arr) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void printSumOfSubSquare(int[][] arr, int k) {

		// this is to store k wise data in another array aka pre processing
		int[][] stripSum = new int[k][arr.length];
		int sum = 0;
		for (int j = 0; j < arr[0].length; j++) {
			sum = 0;

			for (int i = 0; i < k; i++) {
				sum += arr[i][j];
			}
			stripSum[0][j] = sum;

			// tricky stuff
			for (int i = 1; i < arr.length - k + 1; i++) {
				sum += arr[i + k - 1][j] - arr[i - 1][j];
				stripSum[i][j] = sum;
			}

		}


		// printing all the data required
		for (int i = 0; i < stripSum.length; i++) {
			sum = 0;

			for (int j = 0; j < k; j++) {
				sum += stripSum[i][j];
				// System.out.println(sum);
			}

			System.out.print(sum + ", ");

			// tricky stuff
			for (int j = 1; j < stripSum[0].length - k + 1; j++) {
				sum += stripSum[i][j + k - 1] - stripSum[i][j - 1];
				System.out.print(sum + ", ");
			}
			System.out.println();
		}

	}

}
