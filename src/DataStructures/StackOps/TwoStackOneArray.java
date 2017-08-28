package DataStructures.StackOps;

// http://www.geeksforgeeks.org/?p=18754
public class TwoStackOneArray {

	int[] data;
	int top1;
	int top2;
	int size2;
	int size1;

	public TwoStackOneArray(int size1, int size2) {
		this.size1 = size1;
		this.size2 = size2;
		data = new int[size1 + size2];
		this.top1 = -1;
		this.top2 = data.length;
	}

	public void pushInStack1(int value) {

		if (top1 == top2 - 1) {
			System.out.println("stack overflow");
			return;
		}

		top1++;
		data[top1] = value;

	}

	public void pushInStack2(int value) {

		if (top2 == top1 + 1) {
			System.out.println("stack overflow" + value);
			return;
		}

		top2--;
		data[top2] = value;

	}

	public int popInStack1() {

		if (top1 == -1) {
			System.out.println("stack underflow");
			return -1;
		}
		int rv = data[top1];
		top1--;
		return rv;
	}

	public int popInStack2() {
		if (top2 == data.length) {
			System.out.println("stack underflow");
			return -1;
		}

		int rv = data[top2];
		top2++;
		return rv;
	}

	public void displayStack1() {
		int temp = top1;

		while (temp >= 0) {
			System.out.print(data[temp] + ", ");
			temp--;
		}
		System.out.println(".");
	}

	public void displayStack2() {
		int temp = top2;

		while (temp < data.length) {
			System.out.print(data[temp] + ", ");
			temp++;
		}
		System.out.println(".");
	}

}
