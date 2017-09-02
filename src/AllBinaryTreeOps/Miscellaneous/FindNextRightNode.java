package AllBinaryTreeOps.Miscellaneous;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;

public class FindNextRightNode extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		System.out.println(findNextRightNode(root, 5).data);
	}

	public static Node findNextRightNode(Node root, int find) {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node node = queue.removeFirst();

			if (node.data == find) {
				if (queue.isEmpty()) {
					return null;
				} else {
					return queue.getFirst();
				}
			}

			if (node.left != null) {
				queue.addLast(node.left);
			}

			if (node.right != null) {
				queue.addLast(node.right);
			}

		}

		return null;
	}

}
