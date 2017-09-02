package AllBinaryTreeOps.Miscellaneous;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);

		connect2(root);
		traversal(root);

	}

	// VERIFY USING DEBUG

	public static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		public Node(int data) {
			this.data = data;
		}
	}

	// just to manage root exception
	public static void connect(Node root) {

		root.nextRight = null;
		connectSameLevel(root);
	}

	// works for only complete binary tree
	public static void connectSameLevel(Node node) {

		if (node == null) {
			return;
		}

		if (node.left != null) {
			node.left.nextRight = node.right;
		}

		if (node.right != null) {
			node.right.nextRight = node.nextRight != null ? node.nextRight.left : null;
		}

		connectSameLevel(node.left);
		connectSameLevel(node.right);

	}

	public static void connect2(Node root) {

		root.nextRight = null;
		connectSameLevelopti(root);
	}

	// works for all trees
	public static void connectSameLevelopti(Node node) {

		if (node == null) {
			return;
		}

		if (node.nextRight != null) {
			connectSameLevelopti(node.nextRight);
		}

		if (node.left != null && node.right != null) {

			node.left.nextRight = node.right;
			node.right.nextRight = getNextRight(node);
			connectSameLevelopti(node.left);

		} else if (node.left != null) {

			node.left.nextRight = getNextRight(node);
			connectSameLevelopti(node.left);

		} else if (node.right != null) {

			node.right.nextRight = getNextRight(node);
			connectSameLevelopti(node.right);

		} else {

		}

	}

	public static Node getNextRight(Node node) {

		Node temp = node.nextRight;

		while (temp != null) {

			if (temp.left != null) {
				return temp.left;
			}

			if (temp.right != null) {
				return temp.right;
			}

			temp = temp.nextRight;
		}

		return null;

	}

	public static void traversal(Node node) {

		if (node == null) {
			return;
		}
		Node nr = node.nextRight;
		System.out.print(node.data + "=> ");

		if (nr != null) {
			System.out.println(nr.data);
		} else {
			System.out.println("null");
		}
		traversal(node.left);
		traversal(node.right);
	}

}
