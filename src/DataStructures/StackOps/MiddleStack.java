package DataStructures.StackOps;

public class MiddleStack {

	// http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
	private class Node {
		int data;
		Node prev;
		Node next;
	}

	Node top;
	Node middle;
	int size;

	public MiddleStack() {
		this.size = 0;
	}

	public void push(int item) {
		if (this.top == null) {
			this.top = new Node();
			this.top.data = item;
			this.size++;
			this.middle = top;
			return;
		}

		Node node = new Node();
		node.data = item;
		top.next = node;
		node.prev = this.top;
		top = top.next;
		++this.size;

		if (this.size % 2 == 1) {
			this.middle = this.middle.next;
		}

	}

	public int pop() throws Exception {
		if (top == null) {
			throw new Exception("stack is empty");
		}

		int rv = top.data;

		top = top.prev;
		this.size--;

		if (this.size % 2 == 0) {
			this.middle = this.middle.prev;
		}

		return rv;
	}

	public int middle() throws Exception {

		if (middle == null) {
			throw new Exception("stack is empty");
		}
		return this.middle.data;
	}

	public int removeMiddle() throws Exception {

		if (middle == null) {
			throw new Exception("stack is empty");
		}

		int rv = this.middle.data;
		Node prevNode = middle.prev;
		Node nextNode = middle.next;
		middle = middle.prev;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		return rv;

	}

	public void display() {
		Node temp = this.top;

		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.prev;
		}
		System.out.println(".");
	}

}
