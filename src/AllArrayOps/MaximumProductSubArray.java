package AllArrayOps;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println(maximunProductSubarray(arr));
	}

	public static int maximunProductSubarray(int[] arr) {

		int maxProdSoFar = 1;
		int minProdSoFar = 1;
		int rv = 1;

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (val > 0) {

				maxProdSoFar = maxProdSoFar * val;
				minProdSoFar = Math.min(minProdSoFar * val, 1);

			} else if (val == 0) {
				maxProdSoFar = 1;
				minProdSoFar = 1;
			} else {
				int temp = maxProdSoFar;
				maxProdSoFar = Math.max(minProdSoFar * val, 1);
				minProdSoFar = Math.min(temp * val, 1);

			}

			if (maxProdSoFar > rv) {
				rv = maxProdSoFar;
			}
		}

		return rv;

	}

}
