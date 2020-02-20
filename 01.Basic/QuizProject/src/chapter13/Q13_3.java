package chapter13;

import java.util.Scanner;

public class Q13_3 {

	public static void main(String[] args) {
		String str = "";
		String str1 = "";
		int[] ar1 = new int[10];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("총 10개의 숫자를 입력하시오.");
		for (int i = 0; i < ar1.length; i++) {
			System.out.print("숫자 입력 : ");
			ar1[i] = sc.nextInt();
		}
		for (int i = 0; i < ar1.length; i++) {
			if (ar1[i] % 2 == 0) {
				str = str + ar1[i] + ", ";
			} else {
				str1 = str1 + ar1[i] + ", ";
			}
		}
		System.out.println("홀수 : " + str1.substring(0, str1.length() - 2));
		System.out.println("짝수 : " + str.substring(0, str.length() - 2));
	}
}
//길이가 10인 짝수를 배열을 선언하고 총 10개의 정수를 입력받아서 홀수와
//구분해서 출력하라.
//
//출력예시) 총 10개의 숫자를 입력하시오.
//1 2 3 ....... 10개입력
//홀수 : 1, 3, 5, 7
//짝수 : 2, 4, 6, 8, 10
