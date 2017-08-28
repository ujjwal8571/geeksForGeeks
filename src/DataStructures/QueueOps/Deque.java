package DataStructures.QueueOps;

public class Deque {

	private int[] data;
	private int front;
	private int rear;

	public Deque(int size) {
		data = new int[size];
		front = 0;
		rear = -1;
	}

	public boolean isFull() {

		if (isEmpty()) {
			return false;
		}

		return (rear + 1) % data.length == front;
	}

	public boolean isEmpty() {

		return (front == rear) || (front == 0 && rear == -1);

	}

	public void addFirst(int item) {

		if (isFull()) {
			return;
		}

		front--;
		front = (front + data.length) % data.length;
		data[front] = item;

	}

	public void addLast(int item) {

		if (isFull()) {
			return;
		}

		rear++;
		rear %= data.length;
		data[rear] = item;

	}

	public int removeFirst() {

		if (isEmpty()) {
			return -1;
		}

		int rv = data[front];
		front++;

		front = front % data.length;
		return rv;
	}

	public int removeLast() {

		if (isEmpty()) {
			return -1;
		}

		int rv = data[rear];
		rear--;
		rear = (rear + data.length) % data.length;

		return rv;

	}

	public int size() {

		if (rear > front) {
			return rear - front + 1;
		} else {
			return rear + data.length - front + 1;
		}

	}

	public void display() {

		if (isEmpty()) {
			return;
		}

		int i = front;
		while (true) {

			if (i == rear) {
				System.out.println(data[rear]);
				break;
			}

			System.out.print(data[i] + ", ");
			i++;
			i %= data.length;

		}
	}

}
