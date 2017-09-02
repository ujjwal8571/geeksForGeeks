package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class RemoveNodesWithR2fSumLessK extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(12);
		root.right.right.left = new Node(10);
		root.right.right.left.right = new Node(11);
		root.left.left.right.left = new Node(13);
		root.left.left.right.right = new Node(14);
		root.left.left.right.right.left = new Node(15);
		preOrder(root);
		System.out.println();
		removeNodesWithR2f(root, null, false, 0, 45);
		preOrder(root);

	}

	public static void removeNodesWithR2f(Node node, Node parent, boolean ilc, int ssf, int k) {

		if (node == null) {
			return;
		}

		removeNodesWithR2f(node.left, node, true, ssf + node.data, k);
		removeNodesWithR2f(node.right, node, false, ssf + node.data, k);

		if (isLeaf(node)) {
			ssf += node.data;

			if (ssf < k) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

		}

	}

	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ",");
		preOrder(node.left);
		preOrder(node.right);
	}

}
