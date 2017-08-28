package DataStructures.QueueOps;

import java.util.Arrays;

public class KQueues {

	// http://www.geeksforgeeks.org/efficiently-implement-k-queues-single-array/

	public static void main(String[] args) {
		// Let us create 3 queue in an array of size 10
		int k = 3, n = 10;
		KQueues ks = new KQueues(n, k);

		// Let us put some items in queue number 2
		ks.enqueue(15, 2);
		ks.enqueue(45, 2);

		// Let us put some items in queue number 1
		ks.enqueue(17, 1);
		ks.enqueue(49, 1);
		ks.enqueue(39, 1);

		// Let us put some items in queue number 0
		ks.enqueue(11, 0);
		ks.enqueue(9, 0);
		ks.enqueue(7, 0);

		System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
		System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
		System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0));
	}

	int[] data;
	int[] front;
	int[] rear;
	int[] next;
	int free;

	public KQueues(int n, int k) {
		data = new int[n];
		front = new int[k];
		rear = new int[k];
		next = new int[n];
		free = 0;

		Arrays.fill(front, -1);
		Arrays.fill(rear, 0);

		for (int i = 0; i < next.length - 1; i++) {
			next[i] = i + 1;
		}
		next[next.length - 1] = -1;
	}

	public boolean isEmpty(int k) {
		return front[k] == -1;
	}

	public void enqueue(int item, int k) {
		if (free == -1) {
			System.out.println("no space left" + item);
			return;
		}

		int idx = free; // capture index which is free to accept new data

		free = next[idx]; // update value of free index

		if (isEmpty(k)) {
			front[k] = idx; // if queue is empty update front
		} else {
			next[rear[k]] = idx; // else link queue to its next value
		}

		next[idx] = -1; // if front reaches -1 after several dequeue, so to mark the kth queue empty

		rear[k] = idx; // update rear value

		data[idx] = item; // add value to data array

	}

	public int dequeue(int k) {
		if (isEmpty(k)) {
			System.out.println("queue is empty");
			return -1;
		}

		int idx = front[k]; // capture value of front

		front[k] = next[idx]; // update the front value of kth queue

		next[idx] = free; // set the next free index in next[idx] index

		free = idx; // set idx th index of next as free for use

		return data[idx]; // return front value of kth queue

	}

}
