
public class MyExam3 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		Add1(num1, num2);
		Add2(num2, num2);
		
		for(int i=0; i<10; i++) {
			System.out.println(i);
			int numX = 0;
			System.out.println(num1);
		}
		System.out.println(num1);
	}
	public static void Add2(int num3, int num4) {
		int num1 = num3;
		int num2 = num4;
		
		System.out.println(num1 + num2);
	}
	public static void Add1(int num1, int num2) {
		System.out.println(num1+num2);
	}
}
