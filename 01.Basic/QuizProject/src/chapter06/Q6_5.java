package chapter06;

import java.util.Scanner;

public class Q6_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int sum = 0;
		while (true) {
			int num = sc.nextInt();
			sum += num;
			if (num == 0) {
				System.out.println("모든 수 더한 값 : "+sum);
				break;
			}

		}

	}
}

//사용자로부터 계속해서 정수를 입력받는다.
//단 0을 입력받게되면 기존에 입력받은 모든 정수를 더한 후 결과를 출력하시오.
