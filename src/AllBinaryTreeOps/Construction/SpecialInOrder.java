package AllBinaryTreeOps.Construction;

import AllBinaryTreeOps.BaseTree;

public class SpecialInOrder extends BaseTree {

	public static void main(String[] args) {
		int[] inorder = { 1, 5, 10, 40, 30, 15, 28, 20 };

		Node root = specialInOrderConstruct(inorder, 0, inorder.length - 1);

		preOrder(root);

	}

	public static Node specialInOrderConstruct(int[] inorder, int start, int end) {

		if (start > end) {
			return null;
		}

		int maxIdx = findMaxIndex(inorder, start, end);

		Node node = new Node(inorder[maxIdx]);

		node.left = specialInOrderConstruct(inorder, start, maxIdx - 1);
		node.right = specialInOrderConstruct(inorder, maxIdx + 1, end);

		return node;

	}

	public static int findMaxIndex(int[] arr, int start, int end) {

		int max = Integer.MIN_VALUE;
		int maxIdx = -1;

		for (int i = start; i <= end; i++) {

			if (arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}

		}

		return maxIdx;
	}
}
