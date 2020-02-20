import java.util.Scanner;

public class IF_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("두 개의 정수 입력");
		System.out.print("정수 1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 : ");
		int num2 = sc.nextInt();

		int sub = num1 - num2;
		if (sub < 0) {
			sub = -sub;
		}
		System.out.println("결과값 : " + sub);

	}

}

////문제 06-01
//두 개의 정수를 입력 받아서 두 수의 차를 출력하는 프로그램을 작성하라.
//단 입력된 두 수의 순서에 상관없이 출력결과는 항상 0 이상이어야 한다.
//1과2를 입력했다면 1 .... 20과10을 입력했다면 10 .... 
