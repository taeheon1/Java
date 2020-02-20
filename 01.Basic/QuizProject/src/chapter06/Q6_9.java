package chapter06;

import java.util.Scanner;

public class Q6_9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 9; i > 0; i--) {
			System.out.println(num + "x" + i + "=" + (num * i));
		}

	}
}

//사용자로부터 정수 하나를 입력받은 후 그 수에 해당하는 구구단을 역순으로 출력하시오.		