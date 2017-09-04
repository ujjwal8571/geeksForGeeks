package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class DeepestOddLevelLeaf extends BaseTree {

	public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);
        root.right.right.right.right.left = new Node(11);
        
        System.out.println(deepestOddLeveleaf(root, 1 ));
	}

	public static int deepestOddLeveleaf(Node node, int depth) {

		if (node == null) {
			return 0;
		}

		if (isLeaf(node)) {

			if (depth % 2 == 1) {
				return depth;
			} else {
				return 0;
			}
		}
		int lans = deepestOddLeveleaf(node.left, depth + 1);
		int rans = deepestOddLeveleaf(node.right, depth + 1);

		return Math.max(lans, rans);

	}

}
