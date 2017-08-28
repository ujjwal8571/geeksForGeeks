package AllArrayOps;

public class ReplaceWithMaxOnRight {

	public static void main(String[] args) {
		int[] arr = {16, 17, 4, 3, 5, 2};
		replaceWithMaxOnRight(arr);
		
		for(int val:arr) {
			System.out.print(val + ", ");
		}
		
	}

	public static void replaceWithMaxOnRight(int[] arr) {

		int max = -1;
		for (int i = arr.length - 1; i >= 0; i--) {

			int temp = arr[i];
			arr[i] = max;
			if (temp > max) {
				max = temp;
			}
		}
	}

}
