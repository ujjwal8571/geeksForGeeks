package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class MaxPathSum extends BaseTree {

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right.right = new Node(-25);
		root.right.right.left = new Node(3);
		root.right.right.right = new Node(4);
		
		System.out.println(findMaxPathSum(root));
	}

	public static int findMaxPathSum(Node node) {

		if (node == null) {
			return 0;
		}

		int la = findMaxPathSum(node.left);
		int ra = findMaxPathSum(node.right);

		int mySum = Math.max(la, ra) + node.data;

		return Math.max(mySum, Math.max(la, ra));
	}

}
