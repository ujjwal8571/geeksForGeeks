package AllArrayOps.SearchingAndSorting;

public class CommonElementIn3SortedArr {

	public static void main(String[] args) {
		int[] arr1 = { 1, 5, 10, 20, 40, 80 };
		int[] arr2 = { 6, 7, 20, 80, 100 };
		int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
		printCommonElement(arr1, arr2, arr3);
	}

	public static void printCommonElement(int[] arr1, int[] arr2, int[] arr3) {

		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			int num1 = arr1[i];
			int num2 = arr2[j];
			int num3 = arr3[k];

			if (num1 == num2 && num2 == num3) {
				System.out.println(arr1[i]);
				i++;
				j++;
				k++;
			} else if (num1 < num2) {
				i++;
			} else if (num2 < num3) {
				j++;
			} else {
				k++;
			}

		}
	}

}
