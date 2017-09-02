package AllBinaryTreeOps.Miscellaneous;

import AllBinaryTreeOps.BaseTree;

public class FindDiameter extends BaseTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println(diameter(root).diameter);

	}

	public static class DiaPair {
		int diameter;
		int height;

	}

	public static DiaPair diameter(Node node) {

		if (node == null) {
			DiaPair base = new DiaPair();
			base.diameter = 0;
			base.height = -1;
			return base;
		}

		DiaPair ldia = diameter(node.left);
		DiaPair rdia = diameter(node.right);

		DiaPair myPair = new DiaPair();

		myPair.height = Math.max(ldia.height, rdia.height);
		myPair.height += 1;

		myPair.diameter = Math.max(ldia.height + rdia.height + 2, Math.max(ldia.diameter, rdia.diameter));

		return myPair;

	}

}
