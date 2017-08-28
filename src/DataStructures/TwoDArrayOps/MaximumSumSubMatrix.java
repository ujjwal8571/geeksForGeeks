package TwoDArrayOps;

public class MaximumSumSubMatrix {

	// http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/

	public static void main(String[] args) throws java.lang.Exception {
		findMaxSubMatrix(
				new int[][] { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } });
	}

	public static void findMaxSubMatrix(int[][] matrix) {

		int left = 0, right = 0, top = 0, bottom = 0;
		int maxSoFar = Integer.MIN_VALUE;
		for (int leftCol = 0; leftCol < matrix[0].length; leftCol++) {

			int[] temp = new int[matrix.length];

			for (int rightCol = leftCol; rightCol < matrix[0].length; rightCol++) {

				for (int i = 0; i < matrix.length; i++) {
					temp[i] += matrix[i][rightCol];
				}

				int[] currResult = kadaneAlgo(temp);

				if (currResult[0] > maxSoFar) {
					maxSoFar = currResult[0];
					left = leftCol;
					right = rightCol;
					top = currResult[1];
					bottom = currResult[2];

				}

			}
		}

		System.out.println(maxSoFar + "," + left + "," + right + "," + top + "," + bottom);

	}

	public static int[] kadaneAlgo(int[] arr) {
		int[] rv = new int[3];

		int maxSoFar = 0;
		int start = -1, tempStart = -1, end = -1;
		rv[0] = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			maxSoFar += arr[i];

			if (maxSoFar < 0) {
				maxSoFar = 0;
				tempStart = i + 1;
			}

			if (maxSoFar > rv[0]) {
				rv[0] = maxSoFar;
				start = tempStart;
				end = i;
			}

		}

		rv[1] = start;
		rv[2] = end;

		if (rv[2] == -1) {
			maxSoFar = Integer.MIN_VALUE;
			for (int i = 0; i < arr.length; i++) {

				if (arr[i] > maxSoFar) {
					maxSoFar = arr[i];
					arr[1] = arr[2] = i;
				}

			}
		}

		return rv;
	}

}
