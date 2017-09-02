package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class FIndLevelOfNode extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(7);

		System.out.println(findLevel(root, 26, 0));
	}

	public static int findLevel(Node node, int data, int depth) {

		if (node == null) {
			return -1;
		}

		if (node.data == data) {
			return depth;
		}

		int lans = findLevel(node.left, data, depth + 1);
		int rans = findLevel(node.right, data, depth + 1);

		if (lans != -1) {
			return lans;
		} else {
			return rans;
		}

	}

}
