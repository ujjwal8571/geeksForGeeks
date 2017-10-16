package AllLinkedListOps;

public class SegregateEvenAndOdd extends BaseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(10);
		insert(head, 25);
		insert(head, 30);
		insert(head, 20);
		insert(head, 33);
		insert(head, 67);
		insert(head, 12);
		insert(head, 24);
		insert(head, 8);
		
		segregateEvenAndOdd(head);
		display(head);
		

	}

	public static void segregateEvenAndOdd(Node head) {

		Node evenNode = head;

		while (evenNode != null) {

			if (evenNode.data % 2 == 0) {
				swap(head, evenNode);
				head = head.next;
			}
			
			evenNode = evenNode.next;
		}

	}

	public static void swap(Node one, Node two) {
		int temp = one.data;
		one.data = two.data;
		two.data = temp;
	}

}
