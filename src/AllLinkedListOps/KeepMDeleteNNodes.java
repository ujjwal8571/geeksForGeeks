package AllLinkedListOps;

public class KeepMDeleteNNodes extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		insert(head, 20);
		insert(head, 30);
		insert(head, 40);
		insert(head, 50);
		insert(head, 60);
		insert(head, 70);
		insert(head, 80);
		insert(head, 90);
		insert(head, 100);
		insert(head, 110);
		insert(head, 120); 

		display(head);
		keepMDeleteNNodes(head, 3, 2);

		display(head);
	}

	public static void keepMDeleteNNodes(Node head, int m, int n) {

		Node prev = head;

		while (prev != null) {

			for (int i = 0; i < m - 1; i++) {
				
				System.out.println(prev.data);
				prev = prev.next;

				if (prev == null) {
					break;
				}
			}
//			System.out.println(prev.data);
			Node curr = prev.next;

			for (int i = 0; i < n; i++) {

				if (curr == null || prev == null) {
					prev.next = curr;
					break;
				}
				curr = curr.next;
			}

			prev.next = curr;
			prev = curr;
		}

	}

}
