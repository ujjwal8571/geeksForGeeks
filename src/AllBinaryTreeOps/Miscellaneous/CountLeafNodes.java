package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;
import AllBinaryTreeOps.BaseTree.Node;

public class CountLeafNodes extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);

		System.out.println(countLeafNodes(root));


	}

	public static int countLeafNodes(Node node) {
		if (node == null) {
			return 0;

		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		return countLeafNodes(node.left) + countLeafNodes(node.right);

	}

}
