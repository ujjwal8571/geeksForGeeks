package StringOps;

import java.util.Arrays;
import java.util.Comparator;

public class PrintAllAnagramsTogether {
	public static void main(String[] args) {

		String[] wordArr = { "cat", "dog", "tac", "god", "act" };

		printAnagramsTogether(wordArr);
	}

	public static void printAnagramsTogether(String[] sarr) {

		String[] cpyArr = Arrays.copyOf(sarr, sarr.length);
		int[] indices = new int[sarr.length];

		for (int i = 0; i < sarr.length; i++) {

			indices[i] = i;
		}

		for (int i = 0; i < cpyArr.length; i++) {

			String str = cpyArr[i];

			char[] tempArr = str.toCharArray();
			Arrays.sort(tempArr);
			cpyArr[i] = new String(tempArr);
		}

		for (int i = 0; i < cpyArr.length; i++) {

			for (int j = i + 1; j < cpyArr.length; j++) {

				if (cpyArr[i].compareTo(cpyArr[j]) > 0) {

					String temp = cpyArr[i];
					cpyArr[i] = cpyArr[j];
					cpyArr[j] = temp;

					int t = indices[i];
					indices[i] = indices[j];
					indices[j] = t;

				}
			}

		}

		for (int i = 0; i < indices.length; i++) {
			System.out.print(sarr[indices[i]] + ", ");

		}
		System.out.println();

	}
}
