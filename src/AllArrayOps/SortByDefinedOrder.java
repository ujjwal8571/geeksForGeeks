package AllArrayOps;

public class SortByDefinedOrder {

	public static void main(String[] args) {

		int[] arr = { 10, 11, 12 };
		int[] order = { 1, 0, 2 };

		sortByOrder(arr, order);
		for (int val : arr) {
			System.out.print(val + ", ");
		}

	}

	public static void sortByOrder(int[] arr, int[] order) {

		for (int i = 0; i < arr.length; i++) {

			while (order[i] != i) {
				int idxOfThisVal = order[i];
				swap(arr, i, idxOfThisVal);
				swap(order, i, idxOfThisVal);
			}
		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
