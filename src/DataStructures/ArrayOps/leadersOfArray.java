package DataStructures.ArrayOps;

public class leadersOfArray {

	// http://www.geeksforgeeks.org/leaders-in-an-array/
	public static void main(String[] args) {
		int[] arr = { 16, 17, 4, 3, 5, 2 };
		printLeadersOfArray(arr);

	}

	// approach is to traverse array from right to left
	// keep max element stored and compare current with max
	public static void printLeadersOfArray(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				System.out.print(max + ", ");
			}
		}
		System.out.println();
	}

}
