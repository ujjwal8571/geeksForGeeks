package Algorithms.BitManipulation;

public class FindElementAppearingOnce {

	public static void main(String[] args) {

		int[] arr = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7, 12, 1, 3, 2 };
		System.out.println(findElement(arr));
	}

	public static int findElement(int[] arr) {

		int ans = 0;

		for (int i = 0; i < 32; i++) {
			int bit = 1 << i;

			int sum = 0;
			for (int j = 0; j < arr.length; j++) {

				if ((arr[j] & bit) != 0) {
					sum++;
				}

			}

			if (sum % 4 != 0) {
				ans = ans | bit;
			}
		}

		return ans;

	}

}
