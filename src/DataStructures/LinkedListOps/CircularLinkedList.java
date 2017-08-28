package DataStructures.LinkedListOps;

public class CircularLinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node lastNode;
	int size = 0;

	public void addLast(int item) {
		if (lastNode == null) {
			lastNode = new Node(item, null);
			lastNode.next = lastNode;
			this.size++;

			return;
		}

		Node node = new Node(item, null);
		node.next = lastNode.next;
		lastNode.next = node;
		lastNode = node;
		this.size++;
	}

	public void addFirst(int item) {

		if (lastNode == null) {
			lastNode = new Node(item, null);
			lastNode.next = lastNode;
			this.size++;
			return;
		}

		Node first = lastNode.next;

		Node node = new Node(item, null);
		lastNode.next = node;
		node.next = first;
		this.size++;
	}

	public void addAt(int item, int idx) {
		if (lastNode == null) {
			lastNode = new Node(item, null);
			lastNode.next = lastNode;
			this.size++;
			return;
		}

		Node temp = getNodeAt(idx - 1);

		Node node = new Node(item, null);
		this.size++;
		node.next = temp.next;
		temp.next = node;

	}

	public Node getNodeAt(int idx) {

		Node temp = lastNode.next; // head node

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public void display() {
		Node head = lastNode.next;

		Node temp = head;

		while (temp.next != head) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}

		System.out.println(temp.data);
	}

	public CircularLinkedList divideListInTwoHalves() {
		Node midNode = getNodeAt(size / 2 - 1);
		Node midp1 = midNode.next;

		CircularLinkedList rv = new CircularLinkedList();

		midNode.next = lastNode.next;

		lastNode.next = midp1;
		rv.lastNode = lastNode;
		this.lastNode = midNode;

		return rv;
	}

	public void sortedAdd(int item) {

		if (lastNode == null) {
			lastNode = new Node(item, null);
			lastNode.next = lastNode;
			this.size++;
			return;
		}

		Node head = lastNode.next;

		if (item < head.data) {
			this.addFirst(item);
			return;
		} else {

			Node temp = head.next;
			int idx = 1;
			while (temp != head) {
				if (temp.data > item) {
					this.addAt(item, idx);
					return;
				} else {
					idx++;
					temp = temp.next;
				}
			}
		}

		this.addLast(item);

	}
}
