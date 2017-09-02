package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class PrintRootToLeafPaths extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		printR2F(root, "start");
	}

	public static void printR2F(Node node, String psf) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			System.out.println(psf + "=>" + node.data);
			return;
		}

		printR2F(node.left, psf + "=>" + node.data);
		printR2F(node.right, psf + "=>" + node.data);

	}

}
