package AllBinaryTreeOps.Traversal;

import AllBinaryTreeOps.BaseTree;

public class BoundaryTraversal extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		boundaryTraversal(root);

	}

	public static void boundaryTraversal(Node root) {

		Node temp;

		// print left side
		temp = root;
		while (temp.left != null) {
			System.out.println(temp.data);
			temp = temp.left;

		}

		// print leaves

		printLeaves(root);

		// print right side
		temp = root.right;
		while (temp.right != null) {
			System.out.println(temp.data);
			temp = temp.right;

		}
	}

	public static void printLeaves(Node node) {

		if (node == null) {
			retu	rn;
		}

		if (node.left == null && node.right == null) {
			System.out.println(node.data);
			return;
		}

		printLeaves(node.left);
		printLeaves(node.right);
	}

}
