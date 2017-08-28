package AllArrayOps;

public class SortArrayInWaveForm {

	public static void main(String[] args) {
		int[] arr = { 20, 10, 8, 6, 4, 2 };

		waveSort(arr);
		display(arr);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	// just take care of values at odd position
	public static void waveSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 1) {

				if (arr[i] < arr[i - 1]) {
					swap(arr, i, i - 1);
				}

				if (i < arr.length - 1 && arr[i + 1] > arr[i]) {
					swap(arr, i, i + 1);
				}

			}

		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
