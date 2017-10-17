package Algorithms.BitManipulation;

public class NBitsWithoutConsecutive1s {

	public static void main(String[] args) {

		printNBitsWithoutCon1s(3, 1);

	}

	public static void printNBitsWithoutCon1s(int n, int num) {

		if (num >= (1 << (n - 1))) {
			return;
		}

		if (num == 1) {
			System.out.println(num);
		}

		if (num % 2 == 0) {
			System.out.println((num << 1) + 1);

			printNBitsWithoutCon1s(n, (num << 1) + 1);
		}

		System.out.println((num << 1));
		printNBitsWithoutCon1s(n, (num << 1));

	}

}
