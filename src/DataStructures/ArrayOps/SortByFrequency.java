package DataStructures.ArrayOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortByFrequency {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12 };

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (hm.containsKey(val)) {
				hm.put(val, hm.get(val) + 1);
			} else {
				hm.put(val, 1);
			}
		}

		ArrayList<Integer> keys = new ArrayList<>(hm.keySet());

		freqPair[] freqArr = new freqPair[hm.size()];
		int i = 0;
		for (Integer key : keys) {

			freqArr[i] = new freqPair();
			freqArr[i].data = key;
			freqArr[i].freq = hm.get(key);
			i++;

		}

		Arrays.sort(freqArr);

		int idx = 0;
		for (int j = 0; j < freqArr.length; j++) {

			for (int k = 0; k < freqArr[j].freq; k++) {
				arr[idx] = freqArr[j].data;
				idx++;
			}
		}

		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");

	}

	public static class freqPair implements Comparable<freqPair> {

		int data;
		int freq;

		@Override
		public int compareTo(freqPair o) {

			return o.freq - this.freq;
		}

	}

	// public static class Bst {
	//
	// private class Node {
	// int data;
	// int freq;
	// Node left, right;
	// }
	//
	// Node root;
	//
	// public void add(int data) {
	// if (root == null) {
	// root = new Node();
	// root.data = data;
	// root.freq = 1;
	// }
	//
	// add(root, data);
	// }
	//
	// private Node add(Node node, int data) {
	// if (node == null) {
	// Node newNode = new Node();
	// newNode.data = data;
	// newNode.freq = 1;
	// }
	//
	// if (node.data == data) {
	//
	// node.freq++;
	// return null;
	//
	// } else if (node.data < data) {
	// return node.left = add(node.left, data);
	//
	// } else {
	// return node.right = add(node.right, data);
	// }
	//
	// }
	// }

}
