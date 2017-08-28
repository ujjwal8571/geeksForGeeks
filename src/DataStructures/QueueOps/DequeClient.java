package DataStructures.QueueOps;

public class DequeClient {

	public static void main(String[] args) {

		Deque queue = new Deque(5);

		queue.addLast(10);
		queue.addFirst(40);
		queue.addFirst(50);
		queue.addLast(20);
		queue.addLast(30);

		queue.display();
		queue.removeFirst();
		queue.display();
		queue.removeLast();
		queue.display();
		queue.addLast(70);
		queue.display();
		queue.addFirst(80);
		queue.display();
	}

}
