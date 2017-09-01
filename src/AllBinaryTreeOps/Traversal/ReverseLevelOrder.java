package AllBinaryTreeOps.Traversal;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;

public class ReverseLevelOrder extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);

		printLevelOrderReverse(root);

	}

	public static void printLevelOrderReverse(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.addFirst(root);

		while (!queue.isEmpty()) {

			Node node = queue.removeFirst();
			stack.push(node);

			if (node.right != null) {
				queue.addLast(node.right);
			}

			if (node.left != null) {
				queue.addLast(node.left);
			}

		}

		while (!stack.isEmpty()) {
			System.out.println(stack.removeFirst().data);
		}
	}

}
