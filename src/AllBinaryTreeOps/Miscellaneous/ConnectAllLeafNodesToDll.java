package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class ConnectAllLeafNodesToDll extends BaseTree {

	public static void main(String[] args) {

		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		connectLeafNodes(root, new prevNode());

		// to see result in debug window
		System.out.println(root);

	}

	public static class prevNode {
		Node leaf;
	}

	public static void connectLeafNodes(Node node, prevNode prev) {

		if (node == null) {
			return;
		}

		if (isLeaf(node)) {

			if (prev.leaf != null) {

				node.left = prev.leaf;
				prev.leaf.right = node;
			}

			prev.leaf = node;
			return;

		}

		connectLeafNodes(node.left, prev);
		connectLeafNodes(node.right, prev);

	}

}
