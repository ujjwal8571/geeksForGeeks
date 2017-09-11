package AllBinarySearchTreeOps;

import AllBinaryTreeOps.BaseTree;

public class SumOfLargerTransform extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(11);
		root.left = new Node(2);
		root.right = new Node(29);
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(40);
		root.right.right.left = new Node(35);

		traversal(root);
		tranformToSumOfLarger(root, new Sum());
		System.out.println();
		traversal(root);

	}

	public static class Sum {
		int sum;
	}

	public static void tranformToSumOfLarger(Node node, Sum sum) {

		if (node == null) {
			return;
		}

		tranformToSumOfLarger(node.right, sum);

		int temp = node.data;
		node.data = sum.sum;
		sum.sum += temp;

		tranformToSumOfLarger(node.left, sum);
	}

}
