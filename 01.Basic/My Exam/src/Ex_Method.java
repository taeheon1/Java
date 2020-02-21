
public class Ex_Method {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		System.out.println("callMethod : " + callMethod(num1, num2));
	}
	
	public static int callMethod(int a, int b) {
		int c = a + b;
		return c;
	}
}