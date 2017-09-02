package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class CheckIfSumTree extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		System.out.println(checkSumTree(root));

	}

	public static boolean checkSumTree(Node node) {

		if (node == null) {
			return true;
		}

		if (node.left == null && node.right == null) {
			return true;
		}

		boolean lAns = checkSumTree(node.left);
		boolean rAns = checkSumTree(node.right);

		if (lAns == false || rAns == false) {

			return false;
		}

		int childSum = 0;

		if (node.left != null) {

			if (isLeaf(node.left)) {
				childSum += node.left.data;
			} else {
				childSum += 2 * node.left.data;
			}
		}

		if (node.right != null) {
			if (isLeaf(node.right)) {
				childSum += node.right.data;
			} else {
				childSum += 2 * node.right.data;
			}
		}

		if (node.data != childSum) {
			return false;
		}

		return true;

	}

	public static boolean isLeaf(Node node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
}
