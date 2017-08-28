package AllArrayOps.SearchingAndSorting;

import java.util.Arrays;

public class SumPairClosestTok {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 7, 10 }, x = 15;

		Arrays.sort(arr);
		int lo = 0, hi = arr.length - 1;
		int minfn = 0, minsn = 0;
		int maxfn = 0, maxsn = 0;
		int maxClosestSum = Integer.MAX_VALUE;
		int minClosestSum = Integer.MIN_VALUE;

		while (lo < hi) {
			int tempSum = arr[lo] + arr[hi];

			if (tempSum == x) {
				minfn = arr[lo];
				minsn = arr[hi];
				ans = x;
				break;
			}

			if (tempSum > x) {

				if (tempSum < maxClosestSum) {
					maxfn = arr[lo];
					maxsn = arr[hi];
					maxClosestSum = tempSum;
				}
				hi--;

			} else {

				if (tempSum > minClosestSum) {
					minfn = arr[lo];
					minsn = arr[hi];
					minClosestSum = tempSum;
				}

				lo++;

			}
		}

		if (Math.abs(x - maxClosestSum) < Math.abs(x - minClosestSum)) {
			System.out.println(maxfn + ", " + maxsn + ", " + maxClosestSum);
		} else {
			System.out.println(minfn + ", " + minsn + ", " + minClosestSum);
		}

	}

}
