package AllBinarySearchTreeOps;

import AllBinaryTreeOps.BaseTree;

public class ConstructTreeFromPreOrder extends BaseTree {

	public static void main(String[] args) {
		int[] preOrder = { 50, 25, 12, 37, 75, 62, 87 };
		
		Node root = constructTree(preOrder, new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE, preOrder[0]);
		preOrder(root);

	}

	public static class Index {
		int index;
	}

	public static Node constructTree(int[] preOrder, Index index, int min, int max, int key) {

		if (key > min && key < max) {
			Node node = new Node(key);
			index.index++;

			if (index.index == preOrder.length) {
				return null;
			}

			node.left = constructTree(preOrder, index, min, key, preOrder[index.index]);
			node.right = constructTree(preOrder, index, key, max, preOrder[index.index]);

			return node;
		}

		return null;

	}

}
