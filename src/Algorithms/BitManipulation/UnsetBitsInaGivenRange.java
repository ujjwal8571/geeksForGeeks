package Algorithms.BitManipulation;

public class UnsetBitsInaGivenRange {

	public static void main(String[] args) {
		System.out.println(unsetBitsInaGivenRange(42, 2, 5));

	}

	public static int unsetBitsInaGivenRange(int num, int l, int r) {

		int bit = ((1 << r) - 1) ^ ((1 << (l - 1)) - 1);
		bit = ~bit;
		
		return num & bit;
	}

}
