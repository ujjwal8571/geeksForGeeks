package DataStructures.BinaryTreeOps;

public class BinaryTreeWRPClient {

	public static void main(String[] args) {
		//50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 false false true 87 false false
		
		// 50 true 25 true 12 false false true 37 false false true 75 true 62 false false false
		BinaryTreeWRP tree = new BinaryTreeWRP();

		tree.setRandom();
		System.out.println();
		tree.display();
		System.out.println();
		tree.cloneTreeWithRandomPointer();

	}

}
