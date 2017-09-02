package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class SumNumbersR2f extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		root.right.right = new Node(4);

		System.out.println(sumNumsFromR2f(root, 0));
	}

	public static int sumNumsFromR2f(Node node, int num) {

		if (node == null) {
			return 0;
		}

		if (isLeaf(node)) {
			int base = num * 10 + node.data;
			return base;
		}

		int temp = num * 10 + node.data;

		int lsum = sumNumsFromR2f(node.left, temp);
		int rsum = sumNumsFromR2f(node.right, temp);

		return lsum + rsum;
	}

}
