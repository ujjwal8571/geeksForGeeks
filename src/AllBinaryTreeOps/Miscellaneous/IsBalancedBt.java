package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class IsBalancedBt extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(7);
		root.left.left.left.left = new Node(8);

		if (isTreebalanced(root, new HeightMover()))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");

	}

	// O(n) solution on to gfg

	public static class HeightMover {
		int height;
	}

	public static boolean isTreebalanced(Node node, HeightMover height) {
		if (node == null) {
			height.height = 0;
			return true;
		}

		HeightMover lh = new HeightMover();
		HeightMover rh = new HeightMover();

		boolean lAns = isTreebalanced(node.left, lh);
		boolean rAns = isTreebalanced(node.right, rh);

		int mHeight = (lh.height > rh.height) ? lh.height : rh.height;
		mHeight += 1;
		height.height = mHeight;

		if (lAns == false || rAns == false) {
			return false;
		}

		if (Math.abs(lh.height - rh.height) > 1) {
			return false;
		}
		return true;
	}

	
}
