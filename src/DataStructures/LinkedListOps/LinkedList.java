package DataStructures.LinkedListOps;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addFirst(int item) {
		Node temp = new Node(item, this.head);

		if (isEmpty()) {
			this.head = this.tail = temp;
		} else {
			this.head = temp;
		}
		this.size++;
	}

	public void addLast(int item) {
		Node temp = new Node(item, null);

		if (this.isEmpty()) {
			this.head = this.tail = temp;
		} else {
			this.tail.next = temp;
			this.tail = temp;
		}
		this.size++;
	}

	public void addAt(int item, int idx) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Index out of bound");
		}

		if (idx == 0) {
			this.addFirst(item);
		} else if (idx == this.size()) {
			this.addLast(item);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node np1 = nm1.next;

			Node node = new Node(item, np1);
			nm1.next = node;
			this.size++;
		}
	}

	public int getFirst() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("List is empty");
		}
		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {

		Node node = getNodeAt(idx);
		return node.data;
	}

	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		int rv = this.head.data;
		if (this.size() == 1) {
			this.head = this.tail = null;

		} else {

			this.head = this.head.next;

		}
		this.size--;
		return rv;
	}

	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		int rv = this.tail.data;
		if (this.size() == 1) {
			this.head = this.tail = null;

		} else {

			Node node = this.getNodeAt(this.size() - 2);
			node.next = null;
			this.tail = node;

		}
		this.size--;
		return rv;
	}

	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Index out of bound");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;
			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	private Node getNodeAt(int idx) throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Empty List");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Index out of bound");
		}

		Node node = this.head;
		int i = 0;
		while (i < idx) {
			node = node.next;
			i++;
		}
		return node;
	}

	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println("END");
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

	public void kthReverse(int k) {

		if (this.size % k != 0) {

			System.out.println("error");
			return;
		}

		head = kthReverseHelper(head, k);
	}

	public Node kthReverseHelper(Node node, int k) {

		Node curr = node;
		Node prev = null;
		Node next = null;
		int ctr = 0;

		while (curr != null && ctr < k) {

			next = curr.next;
			curr.next = prev;
			prev = curr;

			curr = next;
			ctr++;
		}

		if (curr != null) {
			node.next = kthReverseHelper(curr, k);
		}

		return prev;

	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
	public LinkedList findSumOfLinkedLists(LinkedList other) {
		LinkedList rv = new LinkedList();

		Node nodeCtr1 = this.head;
		Node nodeCtr2 = other.head;
		int sum = 0, carry = 0;
		while (nodeCtr1 != null && nodeCtr2 != null) {

			sum = nodeCtr1.data + nodeCtr2.data + carry;
			carry = sum / 10;
			sum = sum % 10;

			rv.addLast(sum);
			nodeCtr1 = nodeCtr1.next;
			nodeCtr2 = nodeCtr2.next;
		}

		while (nodeCtr1 != null) {

			sum = nodeCtr1.data + carry;
			carry = sum / 10;
			sum = sum % 10;

			rv.addLast(sum);
			nodeCtr1 = nodeCtr1.next;
		}

		while (nodeCtr2 != null) {

			sum = nodeCtr2.data + carry;
			carry = sum / 10;
			sum = sum % 10;
			rv.addLast(sum);
			nodeCtr2 = nodeCtr2.next;
		}

		return rv;

	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// http://www.geeksforgeeks.org/rotate-a-linked-list/
	public void rotate(int k) throws Exception {

		if (k < 0) {
			k += this.size;
		}
		k = k % this.size;

		if (k == 0) {
			return;
		}

		Node km1Node = getNodeAt(this.size - k - 1);
		Node kthNode = km1Node.next;

		tail.next = head;
		head = kthNode;
		tail = km1Node;
		tail.next = null;

	}
}
