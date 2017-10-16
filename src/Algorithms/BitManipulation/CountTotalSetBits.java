package Algorithms.BitManipulation;

import java.util.Scanner;

public class CountTotalSetBits {

	public static void main(String[] args) {

		// Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		//
		// while (n-- > 0) {
		// int num = scn.nextInt();
		// System.out.println(findTotalSetBits2(num));
		// }

		System.out.println(findTotalSetBits2(7));

	}

	// nlogn solution where bits of every number is counted
	public static int findTotalSetBits1(int n) {

		int sum = 0;
		for (int i = 1; i <= n; i++) {

			sum += findTotalSetBitsHelper(i);

		}

		return sum;
	}

	private static int findTotalSetBitsHelper(int num) {
		if (num == 0) {
			return 0;
		}

		int recAns = findTotalSetBitsHelper(num / 2);

		return recAns + ((num % 2 == 0) ? 0 : 1);

	}

	public static int findTotalSetBits2(int n) {

		int msb = findSetMsb(n);
		if (n == ((1 << (msb + 1)) - 1)) {
			System.out.println("hi");
			return (msb + 1) * (1 << (msb));
		}
		

		n = n - (1 << (msb));

		return (n + 1) + findTotalSetBits1(n) + (msb * (1 << (msb - 1)));

	}

	private static int findSetMsb(int n) {

		int rv = 0;

		while (n > 1) {
			n = n >> 1;
			rv++;
		}

		return rv;

	}

}
