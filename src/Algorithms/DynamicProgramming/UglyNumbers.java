package Algorithms.DynamicProgramming;

public class UglyNumbers {

	public static void main(String[] args) {
		System.out.println(findNthUglyNumber(150));

	}

	public static int findNthUglyNumber(int n) {

		int[] ugly = new int[n];

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		int nextMultipleOf2 = 2;
		int nextMultipleOf3 = 3;
		int nextMultipleOf5 = 5;

		ugly[0] = 1;
		int nextUglyNum = 0;

		for (int i = 1; i < ugly.length; i++) {

			nextUglyNum = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));

			ugly[i] = nextUglyNum;

			if (nextUglyNum == nextMultipleOf2) {

				i2++;
				nextMultipleOf2 = ugly[i2] * 2;
			}

			if (nextUglyNum == nextMultipleOf3) {
				i3++;
				nextMultipleOf3 = ugly[i3] * 3;

			}

			if (nextUglyNum == nextMultipleOf5) {
				i5++;
				nextMultipleOf5 = ugly[i5] * 5;
			}
		}

		return ugly[ugly.length - 1];

	}

}
