package Algorithms.BitManipulation;

public class BitsToBeFlippedInAtoGetB {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		int xor = a^b;
		
		System.out.println(CountSetBits.findSetBits(xor));

	}

}
