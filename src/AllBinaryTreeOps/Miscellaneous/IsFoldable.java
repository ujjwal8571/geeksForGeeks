package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class IsFoldable extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.left.right = new Node(5);

		if (isFoldable2(root))
			System.out.println("tree is foldable");
		else
			System.out.println("Tree is not foldable");

	}

	public static boolean isFoldable(Node root) {

		mirror(root.left);

		boolean rv = isSameStructure(root.left, root.right);

		mirror(root.left);

		return rv;

	}

	public static boolean isSameStructure(Node node1, Node node2) {

		if (node1 == null || node2 == null) {
			return true;
		}

		if ((node1.left != null && node2.left == null) || (node1.left == null && node2.left != null)) {
			return false;
		}

		if ((node1.right == null && node2.right != null) || (node1.right != null && node2.right == null)) {
			return false;
		}

		boolean lAns = isSameStructure(node1.left, node2.left);
		boolean rAns = isSameStructure(node1.right, node2.right);

		if (lAns == false || rAns == false) {
			return false;
		}

		return true;

	}

	public static void mirror(Node node) {

		if (node == null) {
			return;
		}

		mirror(node.left);
		mirror(node.right);

		Node temp = node.left;
		node.left = node.right;
		node.right = temp;

	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// method 2

	public static boolean isFoldable2(Node root) {

		if (root == null) {
			return true;
		}

		return isFoldableHelper(root.left, root.right);
	}

	public static boolean isFoldableHelper(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return (isFoldableHelper(node1.left, node2.right) && isFoldableHelper(node1.right, node2.left));

	}
}
