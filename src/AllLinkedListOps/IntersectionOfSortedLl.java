package AllLinkedListOps;

public class IntersectionOfSortedLl extends BaseLinkedList {

	public static void main(String[] args) {

		Node head1 = new Node(2);
		insert(head1, 5);
		insert(head1, 7);
		insert(head1, 11);
		insert(head1, 13);
		insert(head1, 15);
		
		Node head2 = new Node(3);
		insert(head2, 7);
		insert(head2, 11);
		insert(head2, 15);
		insert(head2, 17);
		insert(head2, 47);
		
		Node inters = intersectionOfLl(head1, head2);
		
		display(inters);
		
	}

	public static Node intersectionOfLl(Node head1, Node head2) {
		Node head = null;

		while (head1 != null && head2 != null) {

			if (head1.data == head2.data) {

				Node node = new Node(head1.data);
				node.next = head;
				head = node;
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1.data < head2.data) {

				head1 = head1.next;
			} else {
				head2 = head2.next;
			}
		}

		return head;
	}

}
