package chapter02;

import java.util.Scanner;

public class Q02_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 개의 정수를 입력하세요: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int result = num1 * num2;
		result = (result >=0) ? result :(-1*result);
		System.out.println("(절대값)결과 : " + result);
		
	
		sc.close();
	}
}

