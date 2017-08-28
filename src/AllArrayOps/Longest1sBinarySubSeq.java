package AllArrayOps;

public class Longest1sBinarySubSeq {

	public static void main(String[] args) {
	int[] arr = {1,1,0,0,1,0,1,1,1,0,1,1,1};
		System.out.println(findIdxOfZeroForL1sBSS(arr));

	}

	public static int findIdxOfZeroForL1sBSS(int[] arr) {
		int curr = 0;
		int prevZero = -1;
		int prevprevZero = -1;
		int maxLen = 0, rv = -1;

		while (curr < arr.length) {

			if (arr[curr] == 0) {

				prevprevZero = prevZero;
				prevZero = curr;

			}

			if (prevZero != -1) {
				if (curr - prevprevZero > maxLen) {
					maxLen = curr - prevprevZero + 1;
					rv = prevZero;
				}
			}

			curr++;
		}

		return rv;
	}

}
