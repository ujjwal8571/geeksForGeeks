package AllBinaryTreeOps.Construction;


import AllBinaryTreeOps.BaseTree;

public class ConstructSplTreePreOrder extends BaseTree {

	public static void main(String[] args) {
		int pre[] = new int[] { 10, 30, 20, 5, 15 };
		char preLN[] = new char[] { 'N', 'N', 'L', 'L', 'L' };

		Node root = construct(pre, preLN, new Index());

		preOrder(root);

	}

	public static class Index {
		int idx;
	}

	public static Node construct(int[] pre, char[] isNode, Index idx) {
		if (idx.idx == pre.length) {
			return null;
		}

		if (isNode[idx.idx] == 'L') {
			return new Node(pre[idx.idx]);
		}

		Node node = new Node(pre[idx.idx]);

		idx.idx += 1;
		node.left = construct(pre, isNode, idx);
		idx.idx += 1;
		node.right = construct(pre, isNode, idx);

		return node;
	}

}
