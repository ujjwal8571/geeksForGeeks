package DataStructures.ArrayOps;

import java.util.Arrays;

public class FindNumberOfTriangles {

	public static void main(String[] args) {
		int[] arr = { 10, 21, 22, 100, 101, 200, 300 };
		System.out.println(findNumberOfTriCount(arr));
	}

	// naive approah is of o(n3)
	// we use sorting to reduce it to o(n2)
	public static int findNumberOfTriCount(int[] arr) {

		Arrays.sort(arr);
		int triCount = 0;
		for (int i = 0; i < arr.length - 2; i++) {

			for (int j = i + 1; j < arr.length - 1; j++) {

				int k = j + 1;

				while (k < arr.length && (arr[k] < arr[i] + arr[j])) {
					System.out.println(i + ", " + j + ", " + k);
					k++;
				}

				triCount += k - j - 1;

			}

		}

		return triCount;

	}

}
