package AllArrayOps;

public class Sort012Array {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 2, 0, 1, 0, 2, 2, 1, 0, 2, 0 };
		display(arr);
		sortArray(arr);
		display(arr);

	}

	public static void sortArray(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1;

		while (mid < high) {
			if (arr[mid] == 0) {
				swap(arr, low, mid);
				mid++;
				low++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

}
