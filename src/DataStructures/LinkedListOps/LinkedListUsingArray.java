package DataStructures.LinkedListOps;

public class LinkedListUsingArray {

	private class DataPair {
		int data;
		int nextIdx;
	}

	private DataPair[] arr;
	private int head, tail;

	public LinkedListUsingArray(int size) {

		this.arr = new DataPair[size];

		for (int i = 0; i < arr.length; i++) {
			DataPair dp = new DataPair();
			dp.data = 0;
			dp.nextIdx = -1;
			arr[i] = dp;
		}

		head = -1;
		tail = -1;

	}

	public void addFirst(int data) {
		if (head == -1) {
			arr[0].data = data;
			head = tail = 0;
		}

		int idx = -1;
		for (int i = head; i < arr.length; i++) {
			if (arr[i].nextIdx == -1) {
				idx = i;
				break;
			}
		}

		if (idx == -1) {
			System.out.println("linkedlist overflow");
			return;
		}

		arr[idx].data = data;
		arr[idx].nextIdx = head;
		head = idx;

	}

	
	public void addLast(int data) {
		if (head == -1) {
			arr[0].data = data;
			head = tail = 0;
		}

		int idx = -1;
		for (int i = head; i < arr.length; i++) {
			if (arr[i].nextIdx == -1) {
				idx = i;
				break;
			}
		}

		if (idx == -1) {
			System.out.println("linkedlist overflow");
			return;
		}

		arr[idx].data = data;
		arr[idx].nextIdx = head;
		head = idx;

	}

}
