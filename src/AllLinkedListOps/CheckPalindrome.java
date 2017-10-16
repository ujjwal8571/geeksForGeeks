package AllLinkedListOps;

import java.util.Stack;
import java.util.Vector;


public class CheckPalindrome extends BaseLinkedList {

	public static void main(String[] args) {

		Node head = new Node(4);
		insert(head, 5);
		insert(head, 6);
		insert(head, 5);
		insert(head, 4);

		// System.out.println(isPalindromeUsingStack(head));
		System.out.println(isPalindromeByReverseLl(head));

	}

	public static boolean isPalindromeUsingStack(Node head) {

		Node temp = head;
		Stack<Node> st = new Stack<>();

		while (temp != null) {
			st.push(temp);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			if (temp.data != st.pop().data) {
				return false;
			}

			temp = temp.next;
		}

		return true;

	}

	public static boolean isPalindromeByReverseLl(Node head) {

		Node midNode = getMidNode(head);
		reverse(midNode.next);
		display(midNode.next);

		// check if is palindrome
		Node startTemp = head;
		Node endTemp = midNode.next;

		while (endTemp != null) {
			if (startTemp != endTemp) {
				reverse(midNode.next);
				return false;
			}
			startTemp = startTemp.next;
			endTemp = endTemp.next;
		}
		// end

		reverse(midNode.next);

		return true;
	}

	public static Node getMidNode(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void reverse(Node head) {

		Node prev = null, curr, next;
		curr = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
			System.out.println(prev.data + "," + curr.data + "," + next.data);
		}


	}
}
