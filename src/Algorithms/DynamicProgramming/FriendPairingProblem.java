package Algorithms.DynamicProgramming;

public class FriendPairingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(waysToPairFriends(4));
	}

	public static int waysToPairFriends(int numOfFrnds) {

		int[] strg = new int[numOfFrnds + 1];

		strg[0] = 0;
		strg[1] = 1;
		strg[2] = 2;

		for (int i = 3; i < strg.length; i++) {

			strg[i] = strg[i - 1] + (i - 1) * strg[i - 2];
		}
		
		return strg[numOfFrnds];
	}

}
