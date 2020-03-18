package chapter13;

import java.util.Scanner;

public class Q13_1 {

	public static void main(String[] args) {

		int[] ar1 = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("5개의 정수를 입력하세요");

		for (int i = 0; i < ar1.length; i++) {
			int num = sc.nextInt();
			ar1[i] = num;
		}
		// 1 , 8 , 6 , 10 , 3
		int max = 0;
		int min = ar1[0];
		int sum = 0;
		for (int i = 0; i < ar1.length; i++) {
			if (max < ar1[i]) {
				max = ar1[i]; // 최대값
			}
			if (min > ar1[i]) {
				min = ar1[i];
			}
			sum += ar1[i];
		}
		for (int j = 0; j < ar1.length; j++) {
			if (min > ar1[j]) {
				min = ar1[j];
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println(" 합 계 : " + sum);
	}

}

//길이가 5인 int형 배열을 선언해서 사용자로부터 5개의 정수를 입력받는다.	
//그리고 최대값, 최소값, 모든 수의 합을 구하라. 
//함수(최대,최소,합)를 정의하여 구현하시오.
