package Exam;

public class Exam04 {

	public static void main(String[] args) {

		sum(3,5);
		sub(10,5);
		mul(10,5);
		div(10,5);
	}

	public static void sum(int a, int b) {
		
		System.out.println("덧셈 : " + (a + b));
		return;
	}

	public static void sub(int a, int b) {
		
		System.out.println("뺄셈 : " + (a - b));
		return;
	}

	public static void mul(int a, int b) {
		
		System.out.println("곱셈 : " + (a * b));
		return;
	}

	public static void div(double a, double b) {
		
		System.out.println("나눗셈 : " + (a / b));
		return;
	}
}
