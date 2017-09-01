package AllBinaryTreeOps.Traversal;

import java.util.LinkedList;

import AllBinaryTreeOps.BaseTree;

public class PerfectBtSpecificLevelOrder extends BaseTree {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		root.left.left.left.left = new Node(16);
		root.left.left.left.right = new Node(17);
		root.left.left.right.left = new Node(18);
		root.left.left.right.right = new Node(19);
		root.left.right.left.left = new Node(20);
		root.left.right.left.right = new Node(21);
		root.left.right.right.left = new Node(22);
		root.left.right.right.right = new Node(23);
		root.right.left.left.left = new Node(24);
		root.right.left.left.right = new Node(25);
		root.right.left.right.left = new Node(26);
		root.right.left.right.right = new Node(27);
		root.right.right.left.left = new Node(28);
		root.right.right.left.right = new Node(29);
		root.right.right.right.left = new Node(30);
		root.right.right.right.right = new Node(31);

		printLevelOrder(root);

	}

	public static void printLevelOrder(Node root) {

		LinkedList<Node> queue = new LinkedList<>();

		System.out.print(root.data + "," + root.left.data + "," + root.right.data + ",");

		queue.addLast(root.left);
		queue.addLast(root.right);

		while (!queue.isEmpty()) {

			Node first = queue.removeFirst();
			Node last = queue.removeFirst();

			if (first.left != null) {
				System.out
						.print(first.left.data + "," + last.right.data + "," + first.right.data + "," + last.left.data+",");
			}

			if (first.left != null) {
				queue.addLast(first.left);
				queue.addLast(last.right);
				queue.addLast(first.right);
				queue.addLast(last.left);
			}

		}

	}

	public static void display(LinkedList<Node> list) {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).data + ",");
		}

		System.out.println("END");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
	}

}
