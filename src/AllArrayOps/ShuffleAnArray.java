package AllArrayOps;

public class ShuffleAnArray {

	public static void main(String[] args) {

		int[] arr =  {1, 2, 3, 4, 5, 6, 7, 8};;
		
		display(arr);
		shuffle(arr);
		display(arr);
	}

	public static void shuffle(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {
			int j = (int)(Math.random() * arr.length);
			swap(arr, i, j);
		}

	}

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
