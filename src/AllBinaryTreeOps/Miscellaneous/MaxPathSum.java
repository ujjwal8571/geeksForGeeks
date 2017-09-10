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

		pair p = new pair();

		findMaxPathSum(root, p);
		System.out.println(p.finalAns);
	}

	// pair contains the final answer
	public static class pair {
		int finalAns;
	}

	// in this fuction we return max from root to any of the leaves
	public static int findMaxPathSum(Node node, pair p) {

		if (node == null) {
			return 0;
		}

		int la = findMaxPathSum(node.left, p);
		int ra = findMaxPathSum(node.right, p);

		int fact1 = node.data;
		int fact2 = node.data + la;
		int fact3 = node.data + ra;
		int fact4 = node.data + la + ra;

		// finding max from this node to the leaves
		int maxR2f = Math.max(fact1, Math.max(fact2, fact3));

		// finding the max possible sum for this leaf
		int totalMax = Math.max(maxR2f, fact4);

		// updating the answer in the final class
		p.finalAns = Math.max(p.finalAns, totalMax);

		return maxR2f;

	}

}
