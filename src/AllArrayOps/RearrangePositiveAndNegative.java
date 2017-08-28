package AllArrayOps;

public class RearrangePositiveAndNegative {

	public static void main(String[] args) {
		int[] arr = { -1, 2, 3, 4, -5, 6, -7, 8, 9 };
		rearrangeNumbers(arr);
		display(arr);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	public static void rearrangeNumbers(int[] arr) {
		// put all negative numbers at the end

		int i = 0, j = arr.length - 1;
		while (arr[j] < 0) {
			j--;
		}
		while (i < j) {
			if (arr[i] < 0) {
				swap(arr, i, j);

				while (arr[j] < 0) {
					j--;
				}
			}

			i++;
		}

		// put j's index to first negative value
		j++;

		for (i = 0; i < j && i < arr.length && j < arr.length; i++) {
			// if array has +ve value at odd index then swap
			if (i % 2 == 1 && arr[i] > 0) {
				swap(arr, i, j);
				j++;
			}
		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
