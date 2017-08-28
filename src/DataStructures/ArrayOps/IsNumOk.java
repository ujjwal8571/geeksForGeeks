package DataStructures.ArrayOps;

public class IsNumOk {

	public static void main(String[] args) {
		System.out.println(triangleType(10, 5, 10));

	}

	public static int triangleType(int a, int b, int c) {
		if (a != b && b != c)
			return 1;
		else if (a == b && a == c)
			return 3;
		else
			return 2;
	}

}
