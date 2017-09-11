package AllBinaryTreeOps;

public class BaseTree {

	public static class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static boolean isLeaf(Node node) {

		return node.left == null && node.right == null;
	}

	public static void traversal(Node node) {

		if (node == null) {
			return;
		}

		traversal(node.left);
		System.out.print(node.data + ", ");
		traversal(node.right);
	}
}
