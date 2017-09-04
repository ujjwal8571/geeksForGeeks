package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class PrintAllNodesAtDistKFromleaf extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.right.right = new Node(6);
		root.left.left.left = new Node(14);
		root.left.left.right = new Node(15);
		
		printAllNodesAtDistKFromLeaf(root, 1);

	}

	public static int printAllNodesAtDistKFromLeaf(Node node, int k) {

		if (node == null) {
			return 0;
		}

		if (isLeaf(node)) {
			return 1;
		}

		int la = printAllNodesAtDistKFromLeaf(node.left, k);
		int ra = printAllNodesAtDistKFromLeaf(node.right, k);

		if (la == k || ra == k) {
			System.out.println(node.data);
		}

		return Math.max(la, ra) + 1;

	}

}
