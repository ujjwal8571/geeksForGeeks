package DataStructures.BinaryTreeOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {

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
	private int nextRight;

	public BinaryTree(int[] pre, int[] post) {
		this.root = construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	private Node construct(int[] pre, int presi, int preei, int[] post, int postsi, int postei) {
		if (presi > preei || postsi > postei) {
			return null;
		}
		Node newNode = new Node(pre[presi], null, null);
		this.size++;
		if (presi == preei) {
			return newNode;
		}
		int valIdx = -1;

		for (int i = postsi; i <= postei; i++) {
			if (pre[presi + 1] == post[i]) {
				valIdx = i;
				break;
			}

		}

		int count = valIdx - postsi;

		newNode.left = construct(pre, presi + 1, presi + count + 1, post, postsi, valIdx);

		newNode.right = construct(pre, presi + count + 2, preei, post, valIdx + 1, postei - 1);

		return newNode;
	}

	// this is a code of O(n3)
	// public BinaryTree(int[] level, int[] in) {
	// root = levelOrderHelper(level, in, 0, in.length - 1);
	// }

	public Node levelOrderHelper(int[] level, int[] in, int inStart, int inEnd) {

		if (level.length == 0) {
			return null;
		}

		int val = level[0];

		Node node = new Node(val, null, null);
		this.size++;
		int idx = -1;

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == val) {
				idx = i;
				break;
			}
		}

		int[] leftLevel = extractReqdElements(level, in, inStart, idx - 1);
		int[] rightLevel = extractReqdElements(level, in, idx + 1, inEnd);

		node.left = levelOrderHelper(leftLevel, in, inStart, idx - 1);
		node.right = levelOrderHelper(rightLevel, in, idx + 1, inEnd);

		return node;

	}

	public int[] extractReqdElements(int[] level, int[] in, int inStart, int inEnd) {
		int[] rv = new int[inEnd - inStart + 1];
		int k = 0;

		for (int j = 0; j < level.length; j++) {
			for (int i = inStart; i <= inEnd; i++) {
				if (level[j] == in[i]) {
					rv[k] = level[j];
					k++;
					break;
				}
			}
		}

		return rv;
	}

	public void display() {
		display(this.root);
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

	public void printNodesAtkDistance(int k) {

		printNodesAtKDistHelper(root, 0, k);
	}

	public void printNodesAtKDistHelper(Node node, int depth, int k) {

		if (node == null) {
			return;
		}

		if (depth == k) {
			System.out.println(node.data);
		}

		printNodesAtKDistHelper(node.left, depth + 1, k);
		printNodesAtKDistHelper(node.right, depth + 1, k);

	}

	public void inOrderWithoutRecursion() {

		Node node = root;

		Stack<Node> st = new Stack<>();
		st.push(node);

		node = node.left;
		while (node != null) {
			st.push(node);
			node = node.left;
		}

		while (!st.isEmpty()) {
			Node removed = st.pop();
			System.out.println(removed.data);

			removed = removed.right;
			while (removed != null) {
				st.push(removed);
				removed = removed.left;
			}

		}
	}

	// done using threaded binary trees
	public void morrisTraversal() {
		Node node = root;

		while (node != null) {

			if (node.left == null) {
				System.out.println(node.data);

				Node next = node.right;

				node = next;

			} else {
				Node leftNode = node.left;
				Node rightmost = leftNode;
				while (rightmost.right != null && rightmost.right != node) {
					rightmost = rightmost.right;
				}

				if (rightmost.right == null) {
					rightmost.right = node;
					node = node.left;
				} else {
					rightmost.right = null;
					System.out.println(node.data);
					node = node.right;
				}

			}

		}
	}

	public int maxWidth() {
		int rv = 0;

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> auxiQueue = new LinkedList<>();

		queue.add(root);
		int max = 0;
		while (!queue.isEmpty()) {

			Node removed = queue.removeFirst();
			max++;
			if (removed.left != null) {
				auxiQueue.addLast(removed.left);
			}

			if (removed.right != null) {
				auxiQueue.addLast(removed.right);
			}

			if (queue.isEmpty()) {
				if (max > rv) {
					rv = max;
				}

				max = 0;
				queue = auxiQueue;
				auxiQueue = new LinkedList<>();
			}

		}

		return rv;

	}

	public boolean isBtPresent(BinaryTree other) {

		return isBtPresentHelper(root, other.root);

	}

	private boolean isBtPresentHelper(Node node, Node other) {

		if (node == null) {
			return false;
		}

		if (node.data == other.data) {

			boolean ans = btStartsFromHere(node, other);
			return ans;

		}

		if (isBtPresentHelper(node.left, other)) {

			return true;
		}

		if (isBtPresentHelper(node.right, other)) {
			return true;
		}

		return false;

	}

	private boolean btStartsFromHere(Node node, Node other) {

		if (other == null) {
			return true;
		}

		if (node == null) {
			return false;
		}

		if (node.data != other.data) {
			boolean rv = false;
			return rv;
		}

		if (btStartsFromHere(node.left, other.left) && btStartsFromHere(node.right, other.right)) {
			return true;
		}

		return false;

	}

	public void printAncestors(int val) {

		printAncestorsHelper(root, val);
	}

	private boolean printAncestorsHelper(Node node, int val) {
		if (node == null) {
			return false;
		}

		if (node.data == val) {
			return true;
		}

		boolean leftRes = printAncestorsHelper(node.left, val);
		boolean rightRes = printAncestorsHelper(node.right, val);

		if (leftRes || rightRes) {
			System.out.println(node.data);
		}

		if (leftRes || rightRes) {
			return true;
		} else {
			return false;
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

	public int maxWidth2() {

		int height = this.height();

		int[] widths = new int[height + 1];
		maxWidth2Helper(root, widths, 0);

		int rv = 0;

		for (int i = 0; i < widths.length; i++) {
			if (widths[i] > rv) {
				rv = widths[i];
			}
		}

		return rv;

	}

	private void maxWidth2Helper(Node node, int[] widths, int depth) {

		if (node == null) {
			return;
		}

		widths[depth]++;
		maxWidth2Helper(node.left, widths, depth + 1);
		maxWidth2Helper(node.right, widths, depth + 1);

	}

	public void convertBtToBst() {

		ArrayList<Integer> list = new ArrayList<>();
		getAllNodeValues(root, list);
		Collections.sort(list);
		putAllNodeValues(root, list);

	}

	public void getAllNodeValues(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}

		getAllNodeValues(node.left, list);

		list.add(node.data);

		getAllNodeValues(node.right, list);
	}

	public void putAllNodeValues(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}

		putAllNodeValues(node.right, list);

		node.data = list.remove(list.size() - 1);

		putAllNodeValues(node.left, list);
	}

	public int lowestCommonAncestor(int val1, int val2) {

		return lowestCommonAncestorHelper(root, val1, val2).data;
	}

	private Node lowestCommonAncestorHelper(Node node, int val1, int val2) {
		if (node == null) {
			return null;
		}

		if (node.data == val1 || node.data == val2) {
			return node;
		}

		Node leftAns = lowestCommonAncestorHelper(node.left, val1, val2);
		Node rightAns = lowestCommonAncestorHelper(node.right, val1, val2);

		if (leftAns != null && rightAns != null) {
			return node;
		}

		Node rv = (leftAns != null) ? leftAns : rightAns;
		return rv;

	}

	public void printTreeVertical() {

		HashMap<Integer, ArrayList<Integer>> distFromRoot = new HashMap<>();
		distFromRoot.put(0, new ArrayList<>());

		Node temp = root.left;
		int dist = -1;
		while (temp != null) {
			distFromRoot.put(dist, new ArrayList<>());
			dist--;
			temp = temp.left;
		}

		temp = root.right;
		dist = 1;

		while (temp != null) {
			distFromRoot.put(dist, new ArrayList<>());
			dist++;
			temp = temp.right;
		}

		fillHmForVerticalPrint(root, distFromRoot, 0);

		Set<Integer> keys = distFromRoot.keySet();

		for (int key : keys) {
			ArrayList<Integer> list = distFromRoot.get(key);
			System.out.println(list);
		}

	}

	private void fillHmForVerticalPrint(Node node, HashMap<Integer, ArrayList<Integer>> distFromRoot, int depth) {

		if (node == null) {
			return;
		}

		ArrayList<Integer> list = distFromRoot.get(depth);
		list.add(node.data);

		fillHmForVerticalPrint(node.left, distFromRoot, depth - 1);
		fillHmForVerticalPrint(node.right, distFromRoot, depth + 1);

	}

}
