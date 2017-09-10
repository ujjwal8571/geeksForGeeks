package AllBinaryTreeOps.Miscellaneous;

public class ClosestLeafInBt {

	public static void main(String[] args) {
		Node root = new Node('A');
		root.left = new Node('B');
		root.right = new Node('C');
		root.right.left = new Node('E');
		root.right.right = new Node('F');
		root.right.left.left = new Node('G');
		root.right.left.left.left = new Node('I');
		root.right.left.left.right = new Node('J');
		root.right.right.right = new Node('H');
		root.right.right.right.left = new Node('K');

		char k = 'H';
		System.out.println(k + " is " + findDistToClosestLeaf(root, k));
		k = 'C';
		System.out.println(k + " is " + findDistToClosestLeaf(root, k));
		k = 'E';
		System.out.println(k + " is " + findDistToClosestLeaf(root, k));
		k = 'B';
		System.out.println(k + " is " + findDistToClosestLeaf(root, k));

	}

	public static class Node {
		public char data;
		public Node left;
		public Node right;

		public Node(char data) {
			this.data = data;
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// wrong approach as it only looks at closest leaves below the given node
	public static class pair {
		int leafDistFromNode;
		Node leaf;
	}

	public static Node findClosestLeafToNode(Node root, int nodeData) {

		Node target = findNode(root, nodeData);

		pair ans = findClosestLeafToNodeHelper(target);

		return ans.leaf;

	}

	public static Node findNode(Node node, int data) {

		if (node == null) {
			return null;
		}

		if (node.data == data) {
			return node;

		}

		Node la = findNode(node.left, data);
		Node ra = findNode(node.right, data);

		return (la == null) ? ra : la;

	}

	public static pair findClosestLeafToNodeHelper(Node node) {

		if (node == null) {
			pair base = new pair();
			base.leafDistFromNode = Integer.MAX_VALUE;
			base.leaf = null;
			return base;
		}

		if (node.left == null && node.right == null) {
			pair p = new pair();
			p.leafDistFromNode = 0;
			p.leaf = node;

			return p;
		}

		pair la = findClosestLeafToNodeHelper(node.left);
		pair ra = findClosestLeafToNodeHelper(node.right);

		pair mp = new pair();
		if (la.leafDistFromNode < ra.leafDistFromNode) {
			mp.leafDistFromNode = la.leafDistFromNode + 1;
			mp.leaf = la.leaf;
		} else {

			mp.leafDistFromNode = ra.leafDistFromNode + 1;
			mp.leaf = ra.leaf;
		}

		return mp;

	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static int findClosestBelow(Node node) {

		if (node == null) {
			return Integer.MAX_VALUE;
		}

		if (node.left == null && node.right == null) {
			return 0;
		}

		return (Math.min(findClosestBelow(node.left), findClosestBelow(node.right)) + 1);
	}

	public static int findDistToClosestLeaf(Node root, char k) {

		Node[] ancestors = new Node[10]; // assuming tree size is 10

		return findDistToClosestLeafHelper(root, ancestors, 0, k);

	}

	public static int findDistToClosestLeafHelper(Node node, Node[] ancestors, int height, char k) {

		if (node == null) {
			return Integer.MAX_VALUE;

		}

		if (node.data == k) {

			int rv = findClosestBelow(node);
			System.out.println(node.data + ", " + rv);

			for (int i = height - 1; i >= 0; i--) {

				rv = Math.min(rv, height - i + findClosestBelow(ancestors[i]));
			}

			return rv;
		}

		ancestors[height] = node;
		return Math.min(findDistToClosestLeafHelper(node.left, ancestors, height + 1, k),
				findDistToClosestLeafHelper(node.right, ancestors, height + 1, k));

	}
}
