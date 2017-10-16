package Algorithms.BitManipulation;

public class LargestOfThreeNumbers {

	public static void main(String[] args) {

		int x = 12, y = 43, z = 38;
		System.out.println(findMinUsingBits(x, y, z));

		System.out.println(findMinUsingDivision(x, y, z));
	}

	public static int findMinUsingBits(int x, int y, int z) {

		int minOfXandY = y + ((x - y) & ((x - y) >> Integer.SIZE - 1));

		int finalMin = minOfXandY + ((z - minOfXandY) & ((z - minOfXandY) >> Integer.SIZE - 1));

		return finalMin;
	}

	public static int findMinUsingDivision(int x, int y, int z) {

		int minOfTwo = (x / y == 0) ? x : y;

		return (minOfTwo / z == 0) ? minOfTwo : z;

	}
}
