package StringOps;

public class CountStringFormedUnderabcConstraint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(stringsFormed(4));
	}

	public static int stringsFormed(int n) {

		return 1 + n + n + (n * (n - 1)) / 2 + n * (n - 1) + (n * (n - 1) * (n - 2)) / 2;
	}

}
