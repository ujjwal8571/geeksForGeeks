package Algorithms.BitManipulation;

public class LargerOfTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 6, y = 13;

		System.out.println(findMin(x, y));

	}

	public static int findMin(int x, int y) {

		return y + ((x - y) & ((x - y) >> Integer.SIZE - 1));

	}

	/*
	 * ((x - y) >> Integer.SIZE - 1)
	 * 
	 * if x is bigger then x-y will be +ve number and shifting it 31 times gives me
	 * 0 as sign bit of +ve number is 0 and vice versa
	 * 
	 */

	/*
	 * ((x - y) & ((x - y) >> Integer.SIZE - 1))
	 * 
	 * if x>y then rhs of & gives me 1 this final ans will be x-y otherwise 0
	 * 
	 * 
	 */

}
