package AllArrayOps;

public class ReplaceWithProdOfPrevNnxt {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 6 };
		replaceWithProd(arr);

		for (int val : arr) {
			System.out.print(val + ", ");
		}
	}

	public static void replaceWithProd(int[] arr) {

		int prev = arr[0];
		arr[0] = arr[0] * arr[1];

		for (int i = 1; i < arr.length - 1; i++) {

			int curr = arr[i];

			arr[i] = prev * arr[i + 1];
			prev = curr;

		}

		arr[arr.length - 1] = arr[arr.length - 1] * prev;
	}

}
