package DataStructures.ArrayOps;

public class medianOfTwoSortedArrays {

	// http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
	public static void main(String[] args) {

		int arr1[] = { 1, 12, 15, 26, 38 };
		int arr2[] = { 2, 13, 17, 30, 45 };

		System.out.println(medianOfArrays(arr1, arr2));

		System.out.println(medianOfSortedArrayOpt(arr1, 0, 4, arr2, 0, 4));
	}

	// O(n)
	public static int medianOfArrays(int[] arr1, int[] arr2) {

		int m1 = -1;
		int m2 = -1;
		int len = arr1.length;
		int i = 0, j = 0;
		for (int count = 0; count <= len; count++) {
			if (i == len) {
				m1 = m2;
				m2 = arr2[0];
			}

			if (j == len) {
				m1 = m2;
				m2 = arr2[0];
			}

			if (arr1[i] < arr2[j]) {
				m1 = m2;
				m2 = arr1[i];
				i++;
			} else {
				m1 = m2;
				m2 = arr2[j];
				j++;
			}

		}

		return (m1 + m2) / 2;

	}

	// works in o(log n) using divide and connquer
	public static int medianOfSortedArrayOpt(int[] arr1, int frstStart, int frstEnd, int[] arr2, int scndStart,
			int scndEnd) {

		int size = frstEnd - frstStart + 1;

		if (size == 0) {
			return -1;
		} else if (size == 1) {
			return (arr1[frstStart] + arr2[scndStart]) / 2;
		} else if (size == 2) {

			return (Math.max(arr1[frstStart], arr2[scndStart]) + Math.min(arr1[frstEnd], arr2[scndEnd])) / 2;
		}

		int frstMid = (frstStart + frstEnd) / 2;
		int scndMid = (scndStart + scndEnd) / 2;

		int frstMedian = getMedian(arr1, frstStart, frstEnd);
		int scndMedian = getMedian(arr2, scndStart, scndEnd);

		if (frstMedian > scndMedian) {

			return medianOfSortedArrayOpt(arr1, frstStart, frstMid, arr2, scndMid, scndEnd);
		} else {
			return medianOfSortedArrayOpt(arr1, frstMid, frstEnd, arr2, scndStart, scndMid);
		}

	}

	public static int getMedian(int[] arr, int start, int end) {

		int size = end - start + 1;
		int mid = (start + end) / 2;
		if (size % 2 == 0) {
			return (arr[mid] + arr[mid + 1]) / 2;

		} else {
			return arr[mid];
		}
	}

}
