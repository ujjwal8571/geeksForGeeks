package AllBinaryTreeOps.Traversal;

public class PrintPostoUsingInoAndPreo {

	public static void main(String[] args) {

		int[] pre = { 50, 25, 12, 37, 75, 62, 87 };
		int[] in = { 12, 25, 37, 50, 62, 75, 87 };

		printPostUsingPreIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public static void printPostUsingPreIn(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

		if (preStart > preEnd || inStart > inEnd) {
			return;
		}

		int idx = findIdx(in, inStart, inEnd, pre[preStart]);

		int leftCount = idx - inStart;
		printPostUsingPreIn(pre, preStart + 1, preStart + leftCount, in, inStart, idx - 1);
		printPostUsingPreIn(pre, preStart + leftCount + 1, preEnd, in, idx + 1, inEnd);

		System.out.println(pre[preStart]);

	}

	public static int findIdx(int[] arr, int start, int end, int data) {

		for (int i = start; i <= end; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;
	}

}
