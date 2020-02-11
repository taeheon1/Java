package chapter02;

import java.util.Scanner;

public class Q02_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두개의 정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.printf("%d 나누기 %d의 몫은 : %d입니다 \n",num1, num2, num1/num2);
		System.out.printf("%d 나누기 %d의 나머지는 : %d입니다", num1, num2, num1%num2);

		sc.close();
	}

}
