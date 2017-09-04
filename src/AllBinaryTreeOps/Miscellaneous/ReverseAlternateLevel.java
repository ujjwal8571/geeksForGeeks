package AllBinaryTreeOps.Miscellaneous;

import java.util.LinkedList;

public class ReverseAlternateLevel {

	public static void main(String[] args) {
		Node root = new Node('a');
		root.left = new Node('b');
		root.right = new Node('c');
		root.left.left = new Node('d');
		root.left.right = new Node('e');
		root.right.left = new Node('f');
		root.right.right = new Node('g');
		root.left.left.left = new Node('h');
		root.left.left.right = new Node('i');
		root.left.right.left = new Node('j');
		root.left.right.right = new Node('k');
		root.right.left.left = new Node('l');
		root.right.left.right = new Node('m');
		root.right.right.left = new Node('n');
		root.right.right.right = new Node('o');

		levelOrderLine(root);
		reverseAlternatelevel2(root);
		System.out.println();
		levelOrderLine(root);

	}

	public static class Node {

		char data;
		Node left, right;

		Node(char item) {
			data = item;
			left = right = null;
		}
	}

	// using two traversals
	public static void reverseAlternateLevel(Node root) {

		LinkedList<Character> list = new LinkedList<>();

		getOddLevelNodesInorder(root, list, 0);

		reverseLl(list);

		setOddLevelNodesInorder(root, list, 0);

	}

	public static void reverseLl(LinkedList<Character> list) {
		if (list.size() == 0) {
			return;
		}

		Character val = list.removeFirst();
		reverseLl(list);
		list.addLast(val);
	}

	public static void getOddLevelNodesInorder(Node node, LinkedList<Character> list, int depth) {

		if (node == null) {
			return;
		}

		getOddLevelNodesInorder(node.left, list, depth + 1);

		if (depth % 2 == 1) {

			list.addLast(node.data);
		}

		getOddLevelNodesInorder(node.right, list, depth + 1);
	}

	public static void setOddLevelNodesInorder(Node node, LinkedList<Character> list, int depth) {

		if (node == null) {
			return;
		}

		setOddLevelNodesInorder(node.left, list, depth + 1);

		if (depth % 2 == 1) {

			node.data = list.removeFirst();
		}

		setOddLevelNodesInorder(node.right, list, depth + 1);
	}

	public static void levelOrderLine(Node root) {
		LinkedList<Node> queueParent = new LinkedList<>();
		LinkedList<Node> queueChild = new LinkedList<>();

		queueParent.addLast(root);

		while (!queueParent.isEmpty()) {
			Node removed = queueParent.removeFirst();
			System.out.print(removed.data + " ,");

			if (removed.left != null) {
				queueChild.addLast(removed.left);
			}

			if (removed.right != null) {
				queueChild.addLast(removed.right);
			}

			if (queueParent.isEmpty()) {
				System.out.println("END");
				queueParent = queueChild;
				queueChild = new LinkedList<>();
			}

		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// method 2
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static void reverseAlternatelevel2(Node root) {

		reverseAlternatelevel2Helper(root.left, root.right);

	}

	public static void reverseAlternatelevel2Helper(Node nodeleft, Node noderight) {

		if (nodeleft == null || noderight == null) {
			return;
		}

		swapNodes(nodeleft, noderight);

		reverseAlternatelevel2Helper(nodeleft.left, noderight.right);
		reverseAlternatelevel2Helper(nodeleft.right, noderight.left);

	}

	public static void swapNodes(Node node1, Node node2) {

		char temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}
}
