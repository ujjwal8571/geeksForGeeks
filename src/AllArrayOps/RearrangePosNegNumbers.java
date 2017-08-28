package AllArrayOps;

public class RearrangePosNegNumbers {
	public static void main(String[] args) {
		int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };

		// rearrangeMIS(arr);
		rearangeMMS(arr, 0, arr.length - 1);
		display(arr);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// modified insertion sort
	// has worst O(n^2) complexity
	public static void rearrangeMIS(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] >= 0) {
				continue;
			}

			int j = i - 1;

			while (j >= 0 && arr[j] > 0) {
				swap(arr, j, j + 1);
				j--;
			}
		}
	}

	// modified mergesort
	// has complexity O(nlogn) but space of O(n) with normal merging
	public static void rearangeMMS(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;
		rearangeMMS(arr, low, mid);
		rearangeMMS(arr, mid + 1, high);
		// merge(arr, low, mid, high);
		mergeInConstantSpace(arr, low, mid, high);
	}

	// this merging is consuming extra space
	public static void merge(int[] arr, int low, int mid, int high) {

		int[] one = new int[mid - low + 1];
		int[] two = new int[high - mid];

		int k = 0;
		for (int i = low; i <= mid; i++) {
			one[k] = arr[i];
			k++;
		}

		k = 0;
		for (int i = mid + 1; i <= high; i++) {
			two[k] = arr[i];
			k++;
		}

		int i = 0, j = 0;
		int idx = low;

		while (i < one.length && one[i] < 0) {
			arr[idx] = one[i];
			i++;
			idx++;
		}

		while (j < two.length && two[j] < 0) {
			arr[idx] = two[j];
			j++;
			idx++;
		}

		while (i < one.length) {
			arr[idx] = one[i];
			i++;
			idx++;
		}

		while (j < two.length) {
			arr[idx] = two[j];
			j++;
			idx++;
		}

	}

	// uses reversal rotate algorithm and merges without any extra space
	public static void mergeInConstantSpace(int[] arr, int low, int mid, int high) {

		int i = low, j = mid + 1;

		while (i <= mid && arr[i] < 0) {
			i++;
		}

		while (j <= high && arr[j] < 0) {
			j++;
		}

		reverse(arr, i, mid);
		reverse(arr, mid + 1, j - 1);
		reverse(arr, i, j - 1);

	}

	public static void reverse(int[] arr, int low, int high) {

		for (int i = low, j = high; i < j; i++, j--) {
			swap(arr, i, j);
		}
	}
}
