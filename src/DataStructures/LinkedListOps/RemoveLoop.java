package DataStructures.LinkedListOps;

import java.util.HashMap;

public class RemoveLoop {

	public static void main(String[] args) {

		Node root = new Node(10);
		Node temp = root;

		temp.addNode(new Node(20));
		temp = temp.next;

		temp.addNode(new Node(30));
		temp = temp.next;

		temp.addNode(new Node(40));
		temp = temp.next;

		temp.addNode(new Node(70));
		temp = temp.next;

		temp.addNode(new Node(50));
		temp = temp.next;

		temp.addNode(new Node(60));

		Node toLink = root.getNode(20);
		Node linkFrom = root.getNode(60);

		// System.out.println(root.removeLoop());
		//
		temp = root;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		linkFrom.next = toLink;

		// System.out.println(root.floydCircleDetectingAlgo());
		System.out.println();
		root.floydOptimized();

		temp = root;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		linkFrom.next = toLink;

	}

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public boolean removeLoop() {
			HashMap<Node, Boolean> isNodeVisited = new HashMap<>();

			Node curr = this;
			Node prev = null;
			boolean rv = false;

			while (curr != null) {
				if (isNodeVisited.containsKey(curr)) {
					prev.next = null;
					rv = true;
					break;
				} else {
					isNodeVisited.put(curr, true);
				}

				prev = curr;
				curr = curr.next;

			}

			return rv;
		}

		public Node getNode(int data) {
			Node temp = this;

			while (temp != null) {
				if (temp.data == data) {
					return temp;
				}

				temp = temp.next;
			}

			return null;
		}

		public void addNode(Node node) {
			this.next = node;
		}

		// http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
		public boolean floydCircleDetectingAlgo() {
			Node head = this;

			Node slow = head;
			Node fast = head;
			boolean rv = false;

			while (slow != null && fast != null && fast.next != null) {

				slow = slow.next;
				fast = fast.next.next;

				if (fast == slow) {
					rv = true;
					floydRemoveLoop(slow);
				}
			}

			return rv;
		}

		public void floydRemoveLoop(Node loop) {

			// count number if loop elements

			Node ptr1 = loop;
			Node ptr2 = loop.next;
			int count = 1;

			while (ptr2 != ptr1) {

				ptr2 = ptr2.next;
				count++;
			}

			// place pointers to desired position aka head and count th node

			ptr1 = this;
			ptr2 = this;
			for (int i = 0; i < count; i++) {
				ptr2 = ptr2.next;

			}

			// make pointers meet at start of loop
			while (ptr1 != ptr2) {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;

			}

			// get the node from where loop is starting
			ptr2 = ptr2.next;

			while (ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

			// update next of last node to null

			ptr2.next = null;

		}

		public void floydOptimized() {

			Node slow = this; // putting slow to head
			Node fast = this; // putting slow to head

			while (slow != null && fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;

				if (slow == fast) {
					break;
				}
			}

			if (slow == fast) {

				slow = this;

				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}

				fast.next = null;

			}
		}
	}

}
