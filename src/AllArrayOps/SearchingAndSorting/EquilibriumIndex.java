package AllArrayOps.SearchingAndSorting;

public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println(findEquilibriumIndex(arr));
	}

	public static int findEquilibriumIndex(int[] arr) {

		int rightSum = 0;

		for (int i = 0; i < arr.length; i++) {
			rightSum += arr[i];
		}
		int leftSum = 0;

		for (int i = 0; i < arr.length; i++) {

			rightSum -= arr[i];
			if (leftSum == rightSum) {
				return i;
			}

			leftSum += arr[i];

		}
		return -1;
	}

}
