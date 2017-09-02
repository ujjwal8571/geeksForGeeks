package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class LcaOfBst extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = lcaOfBst(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 8;
		n2 = 14;
		t = lcaOfBst(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = lcaOfBst(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}

	public static Node lcaOfBst(Node node, int val1, int val2) {

		if (node == null) {
			return null;
		}

		if (node.data >= val1 && node.data <= val2) {
			return node;
		} else if (node.data < val1 && node.data < val2) {
			return lcaOfBst(node.right, val1, val2);
		} else {
			return lcaOfBst(node.left, val1, val2);
		}
	}

}
