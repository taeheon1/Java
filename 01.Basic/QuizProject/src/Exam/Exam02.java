package Exam;

public class Exam02 {

	public static void main(String[] args) {
		int num1 = 10;
		double num2 = 10.0;
		String str1 = "홍길동";
		String str2 = new String("전우치");

		System.out.println(str1 + num1 + num2);
		myPrint(str1 + (num1 + num2));
		double num3 = add(num1, num2);

		for (int i = 0; i <= num1; i++) {

			if (i % 2 == 0) {
				System.out.print("짝수" + i);
//			} else {
//				System.out.print("홀수" + i);
			}
		}
	

	int i = 0;
	while(i<=10)
	{
		if (i % 2 == 0) {
			System.out.print("짝수" + i);

		}
			i++;
	}
	
	public static void myPrint(String str) {
		System.out.println(str); // 50줄 정도로 생각
	}

	public static double add(double n1, double n2) {
		return n1 + n2;
	}

	public static int add(int n1, int n2) {
		return n1 + n2;
	}
}

