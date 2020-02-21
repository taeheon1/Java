package chapter06;

import java.util.Scanner;

public class Q6_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두개의 정수 입력");
		System.out.print("정수 1 :");
		int a = sc.nextInt();
		System.out.print("정수 2 :");
		int b = sc.nextInt();
		int sum = 0;
		if (a < b) {
			for (int i = a; i <= b; i++) {
				if (i == b) {
					System.out.print(i + "=");
				} else {
					System.out.print(i + "+");
				}
				sum += i;
			}
			System.out.print(sum);
		} else {
			for (int i = a; i >= b; i--) {
				if (i == b) {
					System.out.print(i + "=");
				} else {
					System.out.print(i + "+");
				}
				sum += i;
				
			}
			System.out.print(sum);
		}
	}
}

// i가 b이면 = 이고 그게 아니면 +

//사용자로부터 2개의 정수를 입력받는다. 가령 2와 6을 입력받았다면
//2+3+4+5+6을 구하는 프로그램을 작성하라.
//단 6과 2를 입력받는다면 6+5+4+3+2=를 구해야 한다.
