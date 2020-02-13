package chapter02;

import java.util.Scanner;

public class Q02_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력하세요 : ");
		System.out.println("첫 번째 숫자");
		int num1 = sc.nextInt();
		System.out.println("두 번째 숫자");
		int num2 = sc.nextInt();
		
		System.out.printf("+ : %d \n", num1 + num2);
        System.out.printf("- : %d \n", num1 - num2);
		System.out.printf("* : %d \n", num1 * num2);
		System.out.printf("/ : %d \n", num1 / num2);
             
        sc.close();
	}

}

