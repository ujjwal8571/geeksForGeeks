package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree.Node;

public class PrintRightViewOfTree {

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);

		printLeftView(root, 0, new maxlevel());

	}

	public static class maxlevel {
		int level = -1;
	}

	public static void printLeftView(Node node, int level, maxlevel maxlvl) {

		if (node == null) {
			return;
		}

		if (level > maxlvl.level) {
			System.out.println(node.data);
			maxlvl.level = level;
		}

		printLeftView(node.right, level + 1, maxlvl);
		printLeftView(node.left, level + 1, maxlvl);
		

	}

}
