package Algorithms.BitManipulation;

public class Swap3Numbers {
	public static void main(String[] args) {
		
	swapAll3Numbers(2, 4, 5);	
	}

	public static void swapAll3Numbers(int a, int b, int c) {

		System.out.println(a + "," + b + "," + c);
		
		a = a ^ b ^ c;
		b = a ^ b ^ c;
		c = a ^ b ^ c;
		a = a ^ b ^ c;

		System.out.println(a + "," + b + "," + c);

	}
}
