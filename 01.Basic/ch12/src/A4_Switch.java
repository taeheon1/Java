
public class A4_Switch {

	public static void main(String[] args) {
		String str = "two";
		
		
		//객체를 비교하는게 아니라 내용을 비교하고 있는것.
		switch (str) {
		case "one" :
			System.out.println("one");
			break;
		case "two" :
			System.out.println("two");
			break;
	
		default:
			System.out.println("default");
		
		}
	}

}
