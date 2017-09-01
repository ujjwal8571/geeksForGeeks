package AllBinaryTreeOps.Traversal;

import AllBinaryTreeOps.BaseTree;

public class MorrisPreOrder extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.left.right.left = new Node(30);
		root.left.right.right = new Node(40);
		root.right.left = new Node(62);
		root.right.right = new Node(87);
		morrisPreOrder(root);

	}

	public static void morrisPreOrder(Node root) {

		Node node = root;

		while (node != null) {

			if (node.left == null) {
				System.out.println(node.data);
				node = node.right;
			} else {

				// setup the thread

				Node rightMost = node.left;

				while (rightMost.right != null && rightMost.right != node) {
					rightMost = rightMost.right;
				}

				if (rightMost.right == null) {
					rightMost.right = node;
					System.out.println(node.data);
					node = node.left;
				} else {
					rightMost.right = null;

					node = node.right;
				}

			}

		}

	}

}
