package DataStructures.Bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import DataStructures.ArrayOps.ArrayRotations;

public class Bst {

	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public Bst() {
		this.root = null;
		this.size = 0;
	}

	public Bst(int[] sa) {
		this.root = this.construct(sa, 0, sa.length - 1);
	}

	public Node construct(int[] sa, int low, int high) {
		if (low > high) {
			return null;
		}

		int mid = (low + high) / 2;

		Node node = new Node(sa[mid], null, null);
		this.size++;

		node.left = construct(sa, low, mid - 1);
		node.right = construct(sa, mid + 1, high);

		return node;

	}

	public void add(int data) {
		if (this.size == 0) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.add(this.root, data);
		}
	}

	public void remove(int data) {

		if (this.size == 1) {
			if (this.root.data == data) {
				this.root = null;
				this.size = 0;
			}
		} else {

			this.remove(this.root, null, false, data);
		}
	}

	private void remove(Node node, Node parent, boolean ilc, int data) {

		if (node == null) {
			return;
		}

		if (data > node.data) {
			remove(node.right, node, false, data);
		} else if (data < node.data) {
			remove(node.left, node, true, data);
		} else {

			if (node.right == null && node.left == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}

			}

			else if (node.right == null && node.left != null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}

			}

			else if (node.right != null && node.left == null) {

				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}

			} else {
				int lmax = this.max(node.left);
				node.data = lmax;
				this.remove(node.left, node, true, lmax);

			}
			this.size--;

		}

	}

	private void add(Node node, int data) {

		if (data < node.data) {
			if (node.left != null) {
				add(node.left, data);
			} else {
				Node nNode = new Node(data, null, null);
				node.left = nNode;
			}
		} else if (data > node.data) {
			if (node.right != null) {
				add(node.right, data);
			} else {
				Node nNode = new Node(data, null, null);
				node.right = nNode;
			}
		} else {
			return;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(this.root);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private void display(Node node) {
		if (node.left != null && node.right != null) {
			System.out.println(node.left.data + " -> " + node.data + " <- " + node.right.data);
			display(node.left);
			display(node.right);
		} else if (node.left != null) {
			System.out.println(node.left.data + " -> " + node.data + "END");
			display(node.left);
		} else if (node.right != null) {
			System.out.println("END" + node.data + " <- " + node.right.data);
			display(node.right);
		} else {
			System.out.println("END " + node.data + " END");
		}
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lHeight = height(node.left);
		int rHeight = height(node.right);

		return Math.max(lHeight, rHeight) + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}

	}

	public int min() {
		return min(this.root);
	}

	private int min(Node node) {

		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}

	public boolean find(int num) {
		return find(this.root, num);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data == node.data) {
			return true;
		} else if (data > node.data) {
			return find(node.right, data);
		} else {
			return find(node.left, data);
		}

	}

	private class inOrderPair {
		int predecessor = Integer.MIN_VALUE;
		int successor = Integer.MAX_VALUE;
	}

	// O(n) code
	public void printInorderPredSucc(int val) {
		inOrderPair pair = new inOrderPair();
		printInorderPredSuccessorHelper(root, val, pair);
		System.out.println("predecessor is " + pair.predecessor);
		System.out.println("successor is " + pair.successor);

	}

	private void printInorderPredSuccessorHelper(Node node, int val, inOrderPair pair) {
		if (node == null) {
			return;
		}

		printInorderPredSuccessorHelper(node.left, val, pair);

		if (node.data < val && node.data > pair.predecessor) {
			pair.predecessor = node.data;
		}

		if (node.data > val && node.data < pair.successor) {
			pair.successor = node.data;
		}

		printInorderPredSuccessorHelper(node.right, val, pair);
	}

	// isBst Ques in binary tree and can be done using inorder traversal

	public int lowestCommonAncestor(int val1, int val2) {

		return lowestCommonAncestorHelper(root, val1, val2).data;
	}

	private Node lowestCommonAncestorHelper(Node node, int val1, int val2) {
		if (node == null) {
			return null;
		}

		if (node.data < val1 && node.data < val2) {
			return lowestCommonAncestorHelper(node.right, val1, val2);
		}

		if (node.data > val1 && node.data > val2) {
			return lowestCommonAncestorHelper(node.left, val1, val2);

		}

		return node;
	}

	public int inOrderPredecessorIter(int val) {

		Node node = root;
		Node pred = null;
		while (node != null) {

			if (node.data < val) {
				pred = node;
				node = node.right;
			} else if (node.data > val) {
				node = node.left;
			} else {

				if (node.left != null) {

					Node lNode = node.left;
					pred = lNode;
					while (pred.right != null) {
						pred = pred.right;
					}

					return pred.data;

				} else {
					return pred.data;
				}

			}

		}

		return -1;

	}

	public int inOrderPredecessorRec(int val) {

		return inOrderPredecessorRecHelper(root, null, val);
	}

	private int inOrderPredecessorRecHelper(Node node, Node pred, int val) {

		if (node == null) {
			return -1;
		}

		if (node.data < val) {
			return inOrderPredecessorRecHelper(node.right, node, val);

		} else if (node.data > val) {
			return inOrderPredecessorRecHelper(node.left, pred, val);

		} else {

			if (node.left != null) {

				Node lNode = node.left;
				pred = lNode;
				while (pred.right != null) {
					pred = pred.right;
				}

				return pred.data;

			} else {
				return pred.data;
			}

		}

	}

	public int kthsmallest(int k) {
		int rv = -1;
		int ctr = 0;
		Stack<Node> st = new Stack<>();
		st.push(root);

		Node temp = root;

		while (temp != null) {
			st.push(temp);
			temp = temp.left;
		}

		while (!st.isEmpty()) {
			Node removed = st.pop();
			ctr++;

			if (ctr == k) {
				return removed.data;
			}
			removed = removed.right;

			while (removed != null) {
				st.push(removed);
				removed = removed.left;
			}

		}

		return rv;

	}

	public void mergeDisplayTwoBsts(Bst other) {

		Stack<Node> myStack = new Stack<>();

		Node temp = this.root;

		while (temp != null) {
			myStack.push(temp);
			temp = temp.left;
		}

		Stack<Node> otherStack = new Stack<>();

		temp = other.root;

		while (temp != null) {
			otherStack.push(temp);
			temp = temp.left;
		}

		while (!myStack.isEmpty() && !otherStack.isEmpty()) {

			Node nodeOfMyTree = myStack.peek();
			Node nodeOfOtherTree = otherStack.peek();

			if (nodeOfMyTree == null && nodeOfOtherTree != null) {
				System.out.println(nodeOfOtherTree.data);
				updateStack(otherStack);
			}

			else if (nodeOfMyTree != null && nodeOfOtherTree == null) {
				System.out.println(nodeOfMyTree.data);
				updateStack(myStack);
			}

			else {

				if (nodeOfMyTree.data < nodeOfOtherTree.data) {
					System.out.println(nodeOfMyTree.data);
					updateStack(myStack);
				} else {

					System.out.println(nodeOfOtherTree.data);
					updateStack(otherStack);

				}

			}

		}

	}

	private void updateStack(Stack<Node> st) {

		if (st.isEmpty()) {
			return;
		}

		Node removed = st.pop();

		removed = removed.right;

		while (removed != null) {
			st.push(removed);
			removed = removed.left;
		}

	}

	public void spoilBst() {

		root.left.right.data = 75;
		root.right.data = 37;

	}

	private class NodePair {
		Node previous;
		Node first;
		Node middle;
		Node last;
	}

	public void correctBst() {
		NodePair pair = new NodePair();

		correctBst(root, pair);

		if (pair.first != null && pair.last != null) {
			int temp = pair.first.data;
			pair.first.data = pair.last.data;
			pair.last.data = temp;

		}

		if (pair.first != null && pair.middle != null) {
			int temp = pair.first.data;
			pair.first.data = pair.middle.data;
			pair.middle.data = temp;

		}

	}

	private void correctBst(Node node, NodePair pair) {
		if (node == null) {
			return;
		}

		correctBst(node.left, pair);

		// work area

		if (pair.previous != null && node.data < pair.previous.data) {

			if (pair.first == null) { // first violation
				pair.first = pair.previous;
				pair.middle = node;

			} else {

				pair.last = node; // second violation
			}

		}

		pair.previous = node;

		// work area ends

		correctBst(node.right, pair);
	}

	public int findCeilValue(int key) {

		return findCeilValueHelper(root, key);
	}

	private int findCeilValueHelper(Node node, int key) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		if (node.data < key) {
			return findCeilValueHelper(node.right, key);

		}

		if (node.data == key) {
			return node.data;
		}

		int ceil = findCeilValueHelper(node.left, key);

		int rv = ceil > key ? ceil : node.data;

		return rv;

	}

	public void mergeTwoBst(Bst other) {

		ArrayList<Integer> myList = new ArrayList<>();
		ArrayList<Integer> otherList = new ArrayList<>();

		getAllNodeValues(this.root, myList);
		getAllNodeValues(other.root, otherList);
		ArrayList<Integer> finalList = mergeSortedArray(myList, otherList);
		this.root = makeBstFromSortedArrayList(finalList, 0, finalList.size() - 1);
		this.size = myList.size() + otherList.size();
	}

	public void getAllNodeValues(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}

		getAllNodeValues(node.left, list);

		list.add(node.data);

		getAllNodeValues(node.right, list);
	}

	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		ArrayList<Integer> rv = new ArrayList<>();
		int i = 0, j = 0;
		while (i < list1.size() && j < list2.size()) {

			if (list1.get(i) < list2.get(j)) {
				rv.add(list1.get(i));
				i++;
			} else {
				rv.add(list2.get(j));
				j++;
			}

		}

		while (i < list1.size()) {
			rv.add(list1.get(i));
			i++;
		}

		while (j < list2.size()) {
			rv.add(list2.get(j));
			j++;
		}

		return rv;

	}

	public Node makeBstFromSortedArrayList(ArrayList<Integer> list, int start, int end) {

		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		Node node = new Node(list.get(mid), null, null);

		node.left = makeBstFromSortedArrayList(list, start, mid - 1);
		node.right = makeBstFromSortedArrayList(list, mid + 1, end);
		return node;

	}

}
