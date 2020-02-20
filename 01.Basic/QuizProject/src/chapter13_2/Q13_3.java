package chapter13_2;

import java.util.Scanner;

public class Q13_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = { "이순신", "강감찬", "을지문덕", "권율", "총점" };
		String[] sub = { "국어", "영어", "수학", "국사", "총점" };
		int[][] ar = new int[4][4];

		for (int i = 0; i < ar.length; i++) {
			System.out.println(name[i] + "의 성적을 입력");
		}
		for (int j = 0; j < ar[i].length; j++) {
			System.out.print(sub[i] + "성적 입력");
			ar[i][j] = sc.nextInt();

		}

	}

}

//성적관리 프로그램을 작성한다. 국어, 영어, 수학, 국사 4과목이고
//학생은 이순신, 강감찬, 을지문덕, 권율 4명이다. 4 by 4 배열을
//선언하고 사용자로부터 4사람의 4과목 점수를 입력받아 
//다음의 형태로 값을 저장하고 총점을 구하는 프로그램을 작성하라.