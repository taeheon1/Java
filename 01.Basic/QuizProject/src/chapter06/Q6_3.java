package chapter06;

import java.util.Scanner;

public class Q6_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 :");

		int fac = sc.nextInt();
		int result = 1;

		while (fac > 0) {
			
			if (fac == 1) {
				System.out.print(fac + " = ");
			} else {
				System.out.print(fac+ " * ");
			}
			result *=fac;
			fac--;
		}
		System.out.print(result);
		sc.close();

	}

}

//정수 하나를 입력받은 후 그 수의 팩토리얼 함수의 결과 를 출력하는 
//프로그램을 while문을 이용하여 구현하시오. 출력예) 입력정수 : 5 
//5*4*3*2*1 = 120
