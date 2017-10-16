package AllLinkedListOps;

public class BaseLinkedList {

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return Integer.toString(this.data);
		}
	}

	public static void display(Node node) {

		Node temp = node;

		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node insert(Node head, int data) {

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = new Node(data);

		return temp.next;
	}
}
