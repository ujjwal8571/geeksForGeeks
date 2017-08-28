package DataStructures.ArrayOps;

public class MergeTwoArraysInFirst {

	public static void main(String[] args) {
		int mPlusN[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		int N[] = { 5, 7, 9, 25 };
		merge(mPlusN, N);

		for (int val : mPlusN) {
			System.out.print(val + ", ");
		}
		System.out.println("end");

	}

	public static void merge(int[] firstArr, int[] secondArr) {

		int k = 0;

		for (int i = 0; i < firstArr.length; i++) {
			if (firstArr[i] == -1) {
				firstArr[i] = secondArr[k];
				k++;
			}
		}
	}

}
