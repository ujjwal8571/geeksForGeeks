package Algorithms.BitManipulation;

public class FindModuloWithNumberPowerOf2 {
	public static void main(String[] args) {

		
		System.out.println(findModulo(19, 4));
	}

	public static int findModulo(int n, int d) { // d is always a power of 2

		return n & (d - 1);
	}
}
