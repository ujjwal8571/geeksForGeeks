package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class FindMaxPathSumBtw2Leaves extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);
		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		root.right.right.right = new Node(0);
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);

		System.out.println(findMaxSumInTwoLeaves(root).sumL2l);

	}

	public static class sumPair {
		int sumL2l;
		int sumM2l;
	}

	public static sumPair findMaxSumInTwoLeaves(Node node) {

		if (node == null) {
			return new sumPair();
		}

		if (isLeaf(node)) {
			sumPair pair = new sumPair();
			pair.sumL2l = node.data;
			pair.sumM2l = node.data;
			return pair;
		}

		sumPair la = findMaxSumInTwoLeaves(node.left);
		sumPair ra = findMaxSumInTwoLeaves(node.right);

		sumPair mp = new sumPair();

		mp.sumM2l = Math.max(la.sumM2l, ra.sumM2l) + node.data;

		mp.sumL2l = node.data + la.sumM2l + ra.sumM2l;
		mp.sumL2l = Math.max(mp.sumL2l, Math.max(la.sumL2l, ra.sumL2l));

		return mp;

	}

}
