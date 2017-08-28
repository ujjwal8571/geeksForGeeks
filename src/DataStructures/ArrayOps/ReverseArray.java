package DataStructures.ArrayOps;

public class ReverseArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6 };
		reverseArray(arr);
		display(arr);
	}

	// http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
	public static void reverseArray(int[] arr) {

		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			swap(arr, i, j);
		}
	}

	// helper function to swap array elements
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// helper function to display array
	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("END");
	}

}
