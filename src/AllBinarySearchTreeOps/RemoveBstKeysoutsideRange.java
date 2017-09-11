package AllBinarySearchTreeOps;

import AllBinaryTreeOps.BaseTree;

public class RemoveBstKeysoutsideRange extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(-13);
		root.right = new Node(14);
		root.left.right = new Node(-8);
		root.right.left = new Node(13);
		root.right.right = new Node(15);
		root.right.left.left = new Node(7);

		removeKeysOutsideRange(null, root, false, -10, 13);

		preOrder(root);

	}

	public static void removeKeysOutsideRange(Node parent, Node node, boolean ilc, int min, int max) {

		if (node == null) {
			return;
		}

		if (node.data >= min && node.data <= max) { // this node is in range
			removeKeysOutsideRange(node, node.left, true, min, node.data);
			removeKeysOutsideRange(node, node.right, false, node.data, max);

		} else {

			if (node.data < min) { // node is below the lower range

				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}

				removeKeysOutsideRange(parent, node.right, ilc, min, max);

			} else { // node is above the higher range

				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
				removeKeysOutsideRange(parent, node.left, ilc, min, max);
			}

		}

	}

}
