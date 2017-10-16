package Algorithms.BitManipulation;

public class TurnOffRightMostSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(turnOffRightMostSetBitOpti(6));
		System.out.println(turnOffRightMostSetBit(6));
	}

	public static int turnOffRightMostSetBit(int num) {

		int bit = 1;
		int count = 1;

		while (true) {

			if ((num & bit) == 0) {
				bit = bit << 1;
				count++;
			} else {
				num = (num & (~(1 << count - 1)));
				break;
			}
		}

		return num;

	}

	public static int turnOffRightMostSetBitOpti(int num) {

		return num & (num - 1);

	}

}
