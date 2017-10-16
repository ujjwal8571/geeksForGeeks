package AllLinkedListOps;

public class FindintersectionPoint extends BaseLinkedList {

	public static void main(String[] args) {

		Node head1 = new Node(10);
		head1.next = new Node(20);
		head1.next.next = new Node(30);
		head1.next.next.next = new Node(40);
		head1.next.next.next = new Node(50);

		Node head2 = new Node(15);
		head2.next = new Node(25);
		head2.next.next = head1.next.next;

		System.out.println(findIntersectionPoint(head1, head2).data);

	}

	// assuming head1 list is longer
	public static Node findIntersectionPoint(Node head1, Node head2) {

		int size1 = 0;
		int size2 = 0;
		// find length f list2

		Node temp = head1;
		while (temp != null) {
			size1++;
			temp = temp.next;
		}
		// find length of list2

		temp = head2;
		while (temp != null) {
			size2++;
			temp = temp.next;
		}

		int diff = size1 - size2;

		temp = head1;
		for (int i = 0; i < diff; i++) {
			temp = temp.next;
		}

		Node temp2 = head2;

		while (temp != null && temp2 != null) {

			if (temp == temp2) {
				return temp;
			}

			temp = temp.next;
			temp2 = temp2.next;
		}

		return null;
	}
}
