package DataStructures.StackOps;

public class MSClient {

	public static void main(String[] args) throws Exception{
		
		MiddleStack st = new MiddleStack();
		
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		
		st.display();
		System.out.println(st.middle());
		System.out.println(st.pop());
		st.display();
		System.out.println(st.removeMiddle());
		System.out.println(st.middle());
		st.display();
		
		
	}

}
