package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class DoubleTree extends BaseTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void doubleTree(Node node) {

		if (node == null) {
			return;
		}

		doubleTree(node.left);
		doubleTree(node.right);

		Node newNode = new Node(node.data);
		Node nl = node.left;
		node.left = newNode;
		newNode.left = nl;

	}

}
