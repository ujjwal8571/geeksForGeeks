package AllArrayOps.SearchingAndSorting;

public class FindTWoRepeatedNumbers {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 4, 5, 1, 3, 1 };
		printTheRepeatedElements(arr);
	}

	// by making equations
	public static void printTheRepeatedElements(int[] arr) {

		// form the x+y=sum and xy=prod

		int reqdSum = 0;
		int reqdProd = 1;

		for (int i = 1; i <= arr.length - 2; i++) {
			reqdProd *= i;
			reqdSum += i;
		}

		int mySum = 0, myProd = 1;

		for (int i = 0; i < arr.length; i++) {
			myProd *= arr[i];
			mySum += arr[i];
		}

		int extraSum = mySum - reqdSum;
		int extraProd = myProd / reqdProd;

		int otherEqn = (int) Math.sqrt((extraSum * extraSum) - (4 * extraProd));

		int firstNum = (extraSum - otherEqn) / 2;
		int secondNum = extraSum - firstNum;

		System.out.println(firstNum + ", " + secondNum);
	}

}
