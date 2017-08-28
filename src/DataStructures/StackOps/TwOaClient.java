package DataStructures.StackOps;

public class TwOaClient {

	public static void main(String[] args) {

		// http://www.geeksforgeeks.org/?p=18754
		TwoStackOneArray st = new TwoStackOneArray(3, 3);
		
		st.pushInStack1(10);
		st.pushInStack1(20);
		st.pushInStack1(30);
		
		st.pushInStack2(40);
		st.pushInStack2(50);
		st.pushInStack2(60);
		
		st.displayStack1();
		st.displayStack2();
		
		System.out.println(st.popInStack1());
		System.out.println(st.popInStack2());
		
		st.displayStack1();
		st.displayStack2();
		
	}

}
