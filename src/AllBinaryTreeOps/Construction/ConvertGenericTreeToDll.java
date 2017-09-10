package AllBinaryTreeOps.Construction;

public class ConvertGenericTreeToDll {

	public static void main(String[] args) {
		// Construting ternary tree as shown in above figure
		Node root = new Node(30);

		root.left = new Node(5);
		root.middle = new Node(11);
		root.right = new Node(63);

		root.left.left = new Node(1);
		root.left.middle = new Node(4);
		root.left.right = new Node(8);

		root.middle.left = new Node(6);
		root.middle.middle = new Node(7);
		root.middle.right = new Node(15);

		root.right.left = new Node(31);
		root.right.middle = new Node(55);
		root.right.right = new Node(65);

		convertGTToDll(root);

		Node temp = root;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.right;
		}
	}

	public static class Node {
		int data;
		Node left;
		Node middle;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static class pair {
		Node head;
		Node tail;;
	}

	public static pair convertGTToDll(Node node) {

		if (node == null) {
			return new pair();

		}

		if (node.left == null && node.right == null) {
			pair p = new pair();
			p.head = node;
			p.tail = node;
			return p;
		}
		pair one = convertGTToDll(node.left);
		pair two = convertGTToDll(node.middle);
		pair three = convertGTToDll(node.right);

		pair mypair = new pair();

		mypair.head = node;
		node.right = one.head;
		if (one.tail != null)
			one.tail.right = two.head;
		if (two.tail != null)
			two.tail.right = three.head;
		mypair.tail = three.tail;

		return mypair;

	}

}
