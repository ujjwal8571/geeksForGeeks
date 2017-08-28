package DataStructures.ArrayOps;

public class InversionsInAnArray {

	public static void main(String[] args) {

		int[] arr = { 2, 4, 1, 3, 5 };
		System.out.println(mergesort(arr, 0, arr.length - 1));
	}

	public static int mergesort(int[] arr, int start, int end) {
		if (start >= end) {
			return 0;
		}

		int mid = (start + end) / 2;

		int lctr = mergesort(arr, start, mid);
		int rctr = mergesort(arr, mid + 1, end);

		int mergectr = merge(arr, start, mid, end);

		return lctr + rctr + mergectr;

	}

	public static int merge(int[] arr, int start, int mid, int end) {

		int[] arr1 = new int[mid - start + 1];
		int[] arr2 = new int[end - mid];

		int[] ans = new int[end - start + 1];
		int temp = 0;
		for (int i = start; i <= mid; i++) {
			arr1[temp] = arr[i];
			temp++;
		}

		temp = 0;
		for (int i = mid + 1; i <= end; i++) {
			arr2[temp] = arr[i];
			temp++;
		}

		int ctr = 0;

		int k = 0, i = 0, j = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {

				

				ans[k] = arr1[i];
				i++;
			} else {
				
				ctr++;
				
				ans[k] = arr2[j];
				j++;
			}
		}

		while (i < arr1.length) {

			 ctr++;
			ans[k] = arr1[i];
			i++;
		}

		while (j < arr2.length) {
			ans[k] = arr2[j];
			j++;
		}

		temp = 0;
		for (int x = start; x <= end; x++) {
			arr[x] = ans[temp];
			temp++;
		}

		return ctr;

	}
}
