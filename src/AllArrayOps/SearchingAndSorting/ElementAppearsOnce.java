package AllArrayOps.SearchingAndSorting;

public class ElementAppearsOnce {

	public static void main(String[] args) {
		
		int[] arr = {7, 3, 5, 4, 5, 3, 4};
		System.out.println(elementAppearsOnce(arr));
	}

	
	public static int elementAppearsOnce(int[] arr) {
		
		int xor = 0;
		
		for(int val:arr) {
			xor = xor ^ val;
		}
		
		return xor;
	}
}
