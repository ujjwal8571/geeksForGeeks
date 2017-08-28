package DataStructures.LinkedListOps;

import java.util.HashMap;

public class CloneLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(new Node(5));
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		list.head.random = list.head.next.next;
		list.head.next.random = list.head;
		list.head.next.next.random = list.head.next.next.next.next;
		list.head.next.next.next.random = list.head.next.next;
		list.head.next.next.next.next.random = list.head.next;

		LinkedList clone = list.clone();

		System.out.println("Original linked list");
		list.print();
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println("\nCloned linked list");
		clone.print();
	}

	public static class Node {
		int data;
		Node next;
		Node random;

		public Node(int data) {
			this.data = data;
		}
	}

	public static class LinkedList {

		private Node head;

		public LinkedList(Node node) {
			this.head = node;
		}

		public void push(int data) {
			Node node = new Node(data);

			node.next = head;
			head = node;
		}

		void print() {
			Node temp = head;
			while (temp != null) {
				Node random = temp.random;
				int randomData = (random != null) ? random.data : -1;
				System.out.println("Data = " + temp.data + ", Random data = " + randomData);
				temp = temp.next;
			}
		}

		public LinkedList clone() {

			LinkedList rv = null;
			// create hashmap
			HashMap<Node, Node> nodeMap = new HashMap<>();
			Node temp = head;
			while (temp != null) {
				nodeMap.put(temp, temp.next);
				temp = temp.next;
			}

			// create clone nodes

			Node curr = this.head;
			Node otherHead = null;
			Node newCurr = new Node(curr.data);
			otherHead = newCurr;
			curr = curr.next;
			while (curr != null) {
				Node newNext = new Node(curr.data);

				newCurr.next = newNext;
				newCurr = newCurr.next;
				curr = curr.next;
			}

			// change next ptr of all origional list

			temp = this.head;
			Node otemp = otherHead;
			while (temp != null && otemp != null) {

				Node tempNext = temp.next;
				temp.next = otemp;
				otemp.random = temp;
				temp = tempNext;
				otemp = otemp.next;
			}

			otemp = otherHead;

			while (otemp != null) {
				otemp.random = otemp.random.random.next;
				otemp = otemp.next;
			}

			temp = this.head;
			while (temp != null) {
				temp.next = nodeMap.get(temp);
				temp = temp.next;
			}

			rv = new LinkedList(otherHead);
			return rv;
		}

	}
}
