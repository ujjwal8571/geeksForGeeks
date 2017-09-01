package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class CheckTreeIdentical extends BaseTree {

	public static void main(String[] args) {

		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		System.out.println(isIdentical(root1, root2));

	}

	public static boolean isIdentical(Node root1, Node root2) {

		return isIdenticalHelper(root1, root2);
	}

	public static boolean isIdenticalHelper(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 != null && node2 == null) {
			return false;
		}
		if (node1 == null && node2 != null) {
			return false;
		}

		if (node1.data != node2.data) {
			return false;
		}

		if (isIdenticalHelper(node1.left, node2.left) == false
				|| isIdenticalHelper(node1.right, node2.right) == false) {
			return false;
		}

		return true;

	}

}
