package AllBinaryTreeOps.Traversal;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;

public class LevelOrderLinewise extends BaseTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);
		
		levelOrderTraversal(root);

	}

	public static void levelOrderTraversal(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> tempQueue = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node removed = queue.removeFirst();
			System.out.print(removed.data + ",");

			if (removed.left != null) {
				tempQueue.addLast(removed.left);
			}

			if (removed.right != null) {
				tempQueue.addLast(removed.right);
			}

			if (queue.isEmpty()) {
				System.out.println("END");
				queue = tempQueue;
				tempQueue = new LinkedList<>();

			}

		}

	}

}
