package Algorithms.BitManipulation;

public class RussianPeasantMultiplication {

	public static void main(String[] args) {

		int x = 12, y = 15;
		System.out.println(multiplyNumbers(x, y));
	}

	public static int multiplyNumbers(int x, int y) {

		int ans = 0;

		while (y > 1) {

			if ((x & 1) != 0) {
			} else {
				ans += x;
			}

			x = x << 1;
			y = y >> 1;
		}

		ans += x;

		return ans;
	}

}
