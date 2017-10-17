package Algorithms.BitManipulation;

public class MultiplyNumberWith10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(multiplyWith10(4));
	}

	public static int multiplyWith10(int num) {
		return (num << 1) + (num << 3);
	}

}
