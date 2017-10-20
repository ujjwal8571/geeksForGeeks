package Algorithms.DynamicProgramming;

public class NthCatalanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthCatalanNumber(10));
	}

	public static int nthCatalanNumber(int n) {

		int[] strg = new int[n];

		strg[0] = strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = 0;
			for (int j = 0; j < i; j++) {
				strg[i] += strg[j] * strg[i - j - 1];
			}

		}

		return strg[n - 1];
	}

}
