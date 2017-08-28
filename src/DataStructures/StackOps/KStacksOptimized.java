
package DataStructures.StackOps;

import java.util.Arrays;

public class KStacksOptimized {

	public static void main(String[] args) {
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;

		KStacksOptimized ks = new KStacksOptimized(n, k);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);
		for (int val : ks.data) {
			System.out.print(val + ", ");
		}
		System.out.println();

		for (int val : ks.next) {
			System.out.print(val + ", ");
		}
		System.out.println();

		for (int val : ks.top) {
			System.out.print(val + ", ");
		}
		System.out.println();

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}

	private int[] data;
	private int[] top;
	private int[] next;
	private int free;

	public KStacksOptimized(int n, int k) {
		this.data = new int[n];
		this.top = new int[k];
		this.next = new int[n];
		this.free = 0;

		Arrays.fill(top, -1);

		for (int i = 0; i < next.length - 1; i++) {
			next[i] = i + 1;
		}
		next[next.length - 1] = -1;

	}

	public void push(int item, int k) {

		if (free == -1) {
			System.out.println("stacks space is full");
			return;
		}

		int idx = free; // gives the current free index

		free = next[idx]; // updates the next free index

		next[idx] = top[k]; // adds previous top value of kth stack to next array

		top[k] = idx; // updates top of kth stack in array

		data[idx] = item; // add item to free index of data array

	}

	public int pop(int k) {

		if (top[k] == -1) {
			System.out.println("stack underflow");
			return -1;
		}

		int topIdx = top[k]; // store the top index of kth stack in topIdx

		int rv = data[topIdx]; // capture value to be returned

		int prevTop = next[topIdx]; // store the index of previous value of kth stack aka previous top of this stack

		top[k] = prevTop; // update top of kth stack

		next[topIdx] = free; // update next free index in current index

		free = topIdx; // marks this index as free

		return rv;

	}

}
