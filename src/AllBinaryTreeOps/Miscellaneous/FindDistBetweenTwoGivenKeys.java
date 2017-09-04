package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class FindDistBetweenTwoGivenKeys extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("Dist(4, 5) = " + findDistBetweenKeys(root, 4, 5));
		System.out.println("Dist(4, 6) = " + findDistBetweenKeys(root, 4, 6));
		System.out.println("Dist(3, 4) = " + findDistBetweenKeys(root, 3, 4));
		System.out.println("Dist(2, 4) = " + findDistBetweenKeys(root, 2, 4));
		System.out.println("Dist(8, 5) = " + findDistBetweenKeys(root, 8, 5));
	}

	public static int findDistBetweenKeys(Node root, int val1, int val2) {

		Node lca = LcaOfBt.lcaOfBt(root, val1, val2);

		int dist1 = distFromRoot2Node(root, val1);
		int dist2 = distFromRoot2Node(root, val2);
		int lcaDist = distFromRoot2Node(root, lca.data);

		return dist1 + dist2 - 2 * lcaDist;

	}

	public static int distFromRoot2Node(Node node, int reqdNode) {

		if (node == null) {
			return 0;
		}

		if (node.data == reqdNode) {
			return 1;
		}

		int la = distFromRoot2Node(node.left, reqdNode);
		int ra = distFromRoot2Node(node.right, reqdNode);

		if (la == 0 && ra == 0) {
			return 0;
		}

		return ((la == 0) ? ra : la) + 1;

	}

}
