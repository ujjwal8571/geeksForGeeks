package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class DeepestLeftLeafNode extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.left.right.left = new Node(9);
		root.right.right.right.right = new Node(10);

		lrPair pair = new lrPair();
		findDlftl(root, pair, false, 0);
		System.out.println(pair.result.data);
	}

	public static class lrPair {
		int maxHeight;
		Node result;
	}

	public static void findDlftl(Node node, lrPair pair, boolean ilc, int depth) {

		if (node == null) {
			return;
		}

		if (isLeaf(node) && ilc == true) {
			if (depth > pair.maxHeight) {
				pair.result = node;
			}

		}

		findDlftl(node.left, pair, true, depth + 1);
		findDlftl(node.right, pair, false, depth + 1);

	}

}
