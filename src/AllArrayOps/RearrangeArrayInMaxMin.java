package AllArrayOps;

public class RearrangeArrayInMaxMin {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		// rearrangeMaxMin(arr);
		rearrangeMaxMinAdvanced(arr);
		display(arr);

	}

	// naive approach with n time and n space

	public static void rearrangeMaxMin(int[] arr) {

		int[] tempArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];

		}

		int i = 0, j = arr.length - 1, k = 0;
		while (k < arr.length) {
			arr[k] = tempArr[j];
			k++;
			j--;
			if (k == arr.length) {
				break;
			}

			arr[k] = tempArr[i];
			i++;
			k++;
		}

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

	// tricky approach by storing two elements in one number
	// AWESOME APPROACH BRO using multiplier and modulo

	public static void rearrangeMaxMinAdvanced(int[] arr) {

		int minIdx = 0, maxIdx = arr.length - 1;
		int maxElement = arr[arr.length - 1] + 1;

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) {

				arr[i] += (arr[maxIdx] % maxElement) * maxElement;
				maxIdx--;
			} else {

				arr[i] += (arr[minIdx] % maxElement) * maxElement;
				minIdx++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] / maxElement;
		}
	}
}
