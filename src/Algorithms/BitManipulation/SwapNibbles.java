package Algorithms.BitManipulation;

public class SwapNibbles {

	public static void main(String[] args) {
		System.out.println(swapNibbles(100));
	}

	public static int swapNibbles(int num) {

		return ((num & 0x0F) << 4) | ((num & 0xF0) >> 4);
	}

}
