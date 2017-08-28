package DataStructures.Bst;

public class ConvertDllToBst {

	public static void main(String[] args) {

		Node head = null;
		head = pushToDll(head, 3);
		head = pushToDll(head, 6);
		head = pushToDll(head, 8);
		head = pushToDll(head, 12);
		head = pushToDll(head, 16);

		displayDll(head);
		int size = sizeOfDll(head);
		HeadNode node = new HeadNode();
		node.node = head;
		Node root = convertDllToTree(node, size);
		preOrder(root);

	}

	public static class Node {
		int data;
		Node prev;
		Node next;
	}

	public static Node pushToDll(Node head, int data) {
		Node node = new Node();
		node.data = data;

		if (head == null) {
			head = node;
			return head;
		}

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
		node.prev = temp;

		return head;

	}

	public static int sizeOfDll(Node head) {

		int rv = 0;
		while (head != null) {
			rv++;
			head = head.next;
		}

		return rv;
	}

	public static void displayDll(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "=> ");
			temp = temp.next;
		}
		System.out.println("end");
	}

	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}

		preOrder(node.prev);
		System.out.println(node.data);
		preOrder(node.next);

	}

	public static class HeadNode {
		Node node;
	}

	// root to leaf approach
	public static Node convertDllToTree(HeadNode head, int size) {

		if (size <= 0) {
			return null;
		}

		Node left = convertDllToTree(head, size / 2);
		Node temp = head.node;
		temp.prev = left;
		head.node = head.node.next;

		temp.next = convertDllToTree(head, size - size / 2 - 1);

		return temp;
	}

}
