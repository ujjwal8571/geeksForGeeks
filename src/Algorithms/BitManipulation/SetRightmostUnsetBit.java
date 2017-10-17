package Algorithms.BitManipulation;

public class SetRightmostUnsetBit {

	public static void main(String[] args) {
		System.out.println(setRightMostUnsetBit(21));

	}

	public static int setRightMostUnsetBit(int num) {

		int temp = ~num;

		int rmsb = FindRightMostSetBit.findRightMostSetBit(temp);

		return num | (1 << (rmsb - 1));
	}
}
