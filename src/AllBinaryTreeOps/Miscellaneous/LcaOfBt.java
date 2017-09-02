package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class LcaOfBt extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("LCA(4, 5) = " + lcaOfBt(root, 4, 5).data);
		System.out.println("LCA(4, 6) = " + lcaOfBt(root, 4, 6).data);
		System.out.println("LCA(3, 4) = " + lcaOfBt(root, 3, 4).data);
		System.out.println("LCA(2, 4) = " + lcaOfBt(root, 2, 4).data);

	}

	public static Node lcaOfBt(Node node, int val1, int val2) {

		if (node == null) {
			return null;
		}

		if (node.data == val1 || node.data == val2) {
			return node;
		}

		Node lans = lcaOfBt(node.left, val1, val2);
		Node rans = lcaOfBt(node.right, val1, val2);

		if (lans != null && rans != null) {
			return node;
		}

		Node rv = (lans == null) ? rans : lans;
		return rv;

	}

}
