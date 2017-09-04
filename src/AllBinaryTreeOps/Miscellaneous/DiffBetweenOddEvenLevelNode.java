package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class DiffBetweenOddEvenLevelNode extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		root.right.right.left = new Node(7);
		
		System.out.println(diffBtwOddEveLvl(root, 1));

	}

	public static int diffBtwOddEveLvl(Node node, int depth) {
		if (node == null) {
			return 0;
		}

		int lsum = diffBtwOddEveLvl(node.left, depth + 1);
		int rsum = diffBtwOddEveLvl(node.right, depth + 1);

		int mysum = lsum + rsum;

		if (depth % 2 == 0) {
			mysum -= node.data;
		} else {
			mysum += node.data;
		}

		return mysum;

	}

}
