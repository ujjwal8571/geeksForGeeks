package AllBinaryTreeOps.Miscellaneous;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;

public class IsBtComplete extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		System.out.println(isCompleteBt(root));

	}

	// once a node has only one child then all the next coming nodes should be
	// leaf nodes for the tree to be complete
	public static boolean isCompleteBt(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		boolean alat = false; // all leaf after this

		while (!queue.isEmpty()) {

			Node node = queue.removeFirst();

			if (alat == true && isLeaf(node) == false) {
				return false;
			}

			if (node.left == null && node.right != null) {
				return false;
			}

			if (node.left != null) {
				queue.addLast(node.left);
			} else {
				alat = true;
			}

			if (node.right != null) {
				queue.addLast(node.right);
			} else {
				alat = true;
			}

		}

		return true;
	}

}
