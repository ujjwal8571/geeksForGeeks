package Algorithms.BitManipulation;

public class MultiplyNumberWith {

	// with 3.5
	public static void main(String[] args) {

		System.out.println(multiplyWith(5));
	}

	// represent number to be multiplied with in form of twos
	// like here 3.5 is 2*x + x+ x/2

	public static int multiplyWith(int num) {

		num = (num << 1) + num + (num >> 1);

		return num;
	}

}
