package Algorithms.BitManipulation;

public class TurnOffParticularBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(turnOffParticularBit(15, 1));
		System.out.println(turnOffParticularBit(15, 2));
		System.out.println(turnOffParticularBit(15, 3));
		System.out.println(turnOffParticularBit(15, 4));
	}

	public static int turnOffParticularBit(int num, int k) {

		return (num & (~(1 << k - 1)));
	}
}
