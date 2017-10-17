package Algorithms.BitManipulation;

public class IsMultipleOf3 {

	public static void main(String[] args) {
		System.out.println(isMultipleOfThree(33));

	}

	public static boolean isMultipleOfThree(int num) {

		int oddCnt = 0, evenCnt = 0;

		while (num > 0) {

			if ((num & 1) != 0) {
				oddCnt++;
			}
			num = num >> 1;
			if ((num & 1) != 0) {
				evenCnt++;
			}
			num = num >> 1;
		}


		if ((evenCnt - oddCnt) % 3 == 0) {
			return true;
		} else {
			return false;
		}

	}

}
