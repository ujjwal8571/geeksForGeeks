package AllBinaryTreeOps.Construction;

import AllBinaryTreeOps.BaseTree;

public class PrePostConstruct extends BaseTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		int[] post = { 4, 5, 2, 6, 7, 3, 1 };

		Node root = construct(pre, post);

		preOrder(root);

	}

	public static Node construct(int[] pre, int[] post) {

		Node root = constructHelper(pre, 0, pre.length - 1, post, 0, post.length - 1);

		return root;
	}

	public static Node constructHelper(int[] pre, int prestart, int preend, int[] post, int poststart, int postend) {

		if (prestart > preend || poststart > postend) {
			return null;
		}

		Node node = new Node(pre[prestart]);

		if (prestart + 1 > preend) {
			return node;
		}

		int idx = 0;
		for (int i = poststart; i <= postend; i++) {
			if (post[i] == pre[prestart + 1]) {
				idx = i;
				break;
			}
		}

		int cnt = idx - poststart;

		node.left = constructHelper(pre, prestart + 1, prestart + cnt + 1, post, poststart, poststart + cnt);
		node.right = constructHelper(pre, prestart + cnt + 2, preend, post, poststart + cnt + 1, postend - 1);

		return node;
	}

}
