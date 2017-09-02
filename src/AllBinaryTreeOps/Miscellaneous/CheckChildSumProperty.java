package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class CheckChildSumProperty extends BaseTree {

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);

		System.out.println(isChildSumProp(root));

	}

	public static boolean isChildSumProp(Node node) {
		if (node == null) {
			return true;
		}

		if (node.left == null && node.right == null) {
			return true;
		}

		int mySum = 0;
		if (node.left != null) {
			mySum += node.left.data;
		}

		if (node.right != null) {
			mySum += node.right.data;
		}

		if (mySum != node.data) {
			return false;
		}

		if (isChildSumProp(node.left) == false || isChildSumProp(node.right) == false) {
			return false;
		}

		return true;

	}

}
