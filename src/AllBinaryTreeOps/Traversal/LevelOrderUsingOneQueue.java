package AllBinaryTreeOps.Traversal;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;

public class LevelOrderUsingOneQueue extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.right = new Node(75);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.right.left = new Node(62);
		root.right.right = new Node(87);
		
		printLevelOrder(root);

	}

	public static void printLevelOrder(Node root) {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);

		while (true) {

			int nc = queue.size();

			if (nc == 0) {
				break;
			}

			while (nc > 0) {

				Node node = queue.removeFirst();
				System.out.print(node.data + ", ");

				if (node.left != null) {
					queue.addLast(node.left);
				}

				if (node.right != null) {
					queue.addLast(node.right);
				}

				nc--;

			}

			System.out.println(".");

		}
	}

}
