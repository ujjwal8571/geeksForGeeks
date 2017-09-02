package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class MaximumSumR2f extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);

		System.out.println(maxSumR2f(root, 0));
	}

	public static int maxSumR2f(Node node, int sum) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		if (isLeaf(node)) {
			return sum+node.data;
		}

		int lsum = maxSumR2f(node.left, sum + node.data);
		int rsum = maxSumR2f(node.right, sum + node.data);

		return Math.max(lsum, rsum);

	}

}
