package DataStructures.BinaryTreeOps;

public class BinaryTreeWRP {
	private class Node {
		int data;
		Node left;
		Node right;
		Node random;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;
	private int nextRight;

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node.left != null && node.right != null) {
			System.out.println(node.left.data + " -> " + node.data + " <- " + node.right.data);
			display(node.left);
			display(node.right);
		} else if (node.left != null) {
			System.out.println(node.left.data + " -> " + node.data + "END");
			display(node.left);
		} else if (node.right != null) {
			System.out.println("END" + node.data + " <- " + node.right.data);
			display(node.right);
		} else {
			System.out.println("END " + node.data + " END");
		}
	}

	public void setRandom() {

		root = new Node(50, null, null);
		root.left = new Node(25, null, null);
		root.right = new Node(75, null, null);
		root.left.left = new Node(12, null, null);
		root.left.right = new Node(37, null, null);
		root.right.left = new Node(62, null, null);
		root.right.right = new Node(87, null, null);

		Node n1 = root;
		Node n2 = root.left;
		Node n3 = root.right;
		Node n4 = n2.left;
		Node n5 = n2.right;
		Node n6 = n3.left;
		Node n7 = n3.right;

		n2.random = n3;
		n3.random = n5;
		n4.random = n1;
		n5.random = n1;
		n6.random = n2;
		n7.random = n6;
	}

	public Node cloneTreeWithRandomPointer() {

		duplicateTree(root);
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``");
		// display(root);
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		setRandom(root);
		Node rv = restoreTree(root);

		display(rv);

		return rv;

	}

	private void setRandom(Node node) {
		if (node == null || node.left == null) {
			return;
		}

		node.left.random = node.random.left;
		setRandom(node.left.left);
		setRandom(node.right);

	}

	private void duplicateTree(Node node) {

		if (node == null) {
			return;
		}

		duplicateTree(node.left);
		duplicateTree(node.right);

		Node newNode = new Node(node.data, null, null);
		newNode.left = node.left;

		
		node.left = newNode;

	}

	private Node restoreTree(Node node) {
		if (node == null || node.left == null || node.left.left == null) {
			return null;
		}

		
		Node ld = restoreTree(node.left.left);
		Node rd = restoreTree(node.right);
		
		
		Node clonedNode = node.left;
		node.left = node.left.left;
		clonedNode.left = ld;
		clonedNode.right = rd;

		return clonedNode;
	}

}
