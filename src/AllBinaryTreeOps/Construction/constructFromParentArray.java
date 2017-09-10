package AllBinaryTreeOps.Construction;

import AllBinaryTreeOps.BaseTree;

public class constructFromParentArray extends BaseTree {

	public static void main(String[] args) {

		int[] parent = { 1, 5, 5, 2, 2, -1, 3 };

		constructTree(parent);
		preOrder(root);

	}

	public static Node root;

	public static Node createNode(int[] parent, int idx, Node[] nodes) {

		if (nodes[idx] != null) {
			return nodes[idx];
		}

		Node node = new Node(idx); // create node
		nodes[idx] = node;

		// create parent node of this node

		if (parent[idx] == -1) {
			root = node;
			return node;
		}

		Node myParent = createNode(parent, parent[idx], nodes);

		// link this node to the parent node

		if (myParent.left == null) {
			myParent.left = node;
		} else {
			myParent.right = node;
		}

		return node;

	}
	
	public static void constructTree(int[] parent) {

		Node[] nodes = new Node[parent.length];

		for (int i = 0; i < parent.length; i++) {
			nodes[i] = createNode(parent, i, nodes);
		}
	}

}
