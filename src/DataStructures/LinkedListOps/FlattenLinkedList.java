package DataStructures.LinkedListOps;

public class FlattenLinkedList {

	public static void main(String args[]) {
		LinkedList L = new LinkedList();

		/*
		 * Let us create the following linked list 5 -> 10 -> 19 -> 28 | | | | V V V V 7
		 * 20 22 35 | | | V V V 8 50 40 | | V V 30 45
		 */

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.right = L.push(L.head.right, 20);
		L.head.right = L.push(L.head.right, 10);

		L.head.right.right = L.push(L.head.right.right, 50);
		L.head.right.right = L.push(L.head.right.right, 22);
		L.head.right.right = L.push(L.head.right.right, 19);

		L.head.right.right.right = L.push(L.head.right.right.right, 45);
		L.head.right.right.right = L.push(L.head.right.right.right, 40);
		L.head.right.right.right = L.push(L.head.right.right.right, 35);
		L.head.right.right.right = L.push(L.head.right.right.right, 20);

		// L.printList();

		// flatten the list
		L.head = L.flatten(L.head);

		L.printList();
	}

	public static class LinkedList {

		private class Node {
			int data;
			Node right;
			Node down;
		}

		private Node head;

		public void printList() {

			Node tempHead = head;
			// while (tempHead != null) {
			Node temp = tempHead;
			while (temp != null) {
				System.out.print(temp.data + ",");
				temp = temp.down;
			}
			// tempHead = tempHead.right;

			System.out.println("end");
			// }
		}

		public Node push(Node node, int data) {

			Node newNode = new Node();
			newNode.data = data;

			newNode.down = node;
			node = newNode;
			return node;

		}

		public Node flatten(Node node) {
			if (node == null || node.right == null) {
				return node;
			}

			node.right = this.flatten(node.right);

			node = merge(node, node.right);

			return node;

		}

		private Node merge(Node one, Node two) {
			if (one == null) {
				return two;
			}

			if (two == null) {
				return one;
			}

			Node result;
			if (one.data < two.data) {
				result = one;
				result.down = merge(one.down, two);
			} else {
				result = two;
				result.down = merge(one, two.down);
			}

			return result;

		}
	}

}
