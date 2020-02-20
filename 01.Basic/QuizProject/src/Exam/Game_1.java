package Exam;

import java.util.Random;
import java.util.Scanner;

public class Game_1 {
	public static String str(int n) {
		String str = null;

		if (n == 1) {
			str = "가위";
		} else if (n == 2) {
			str = "바위";
		} else {
			str = "보";
		}
		return str;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int num1, num;

		while (true) {
			System.out.print("무엇을 내겠습니까?\t(1. : 가위 2. : 바위 3. : 보 0 : 종료)");
			num1 = sc.nextInt();
			num = ran.nextInt(3) + 1; // 0 ~ 3

			if (num1 == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else if ((num1 > 3) || (num1 < 0)) {
				System.out.println("0 ~ 3까지의 수만 입력해 주세요");
				continue;
			}
			System.out.println("사용자 : " + str(num1) + ", 컴퓨터 : " + str(num));

			if (num1 - num == 0) {
				System.out.println("비겼습니다.");
			} else if ((num1 - num == -1) || (num1 - num == 2)) {
				System.out.println("졌습니다.");
			} else {
				System.out.println("이겼습니다.");
			}
//			if ((num1 == 1) && (num == 1)) {
//				System.out.println("사용자 : 가위, 컴퓨터 : 가위 \n비겼습니다.");
//
//			} else if ((num1 == 1) && (num == 2)) {
//				System.out.println("사용자 : 가위, 컴퓨터 : 바위 \n졌습니다.");
//
//			} else if ((num1 == 1) && (num == 3)) {
//				System.out.println("사용자 : 가위, 컴퓨터 : 보 \n이겼습니다.");
//			}
//
//			if ((num1 == 2) && (num == 1)) {
//				System.out.println("사용자 : 바위, 컴퓨터 : 가위 \n이겼습니다.");
//
//			} else if ((num1 == 2) && (num == 2)) {
//				System.out.println("사용자 : 바위, 컴퓨터 : 바위 \n비겼습니다.");
//
//			} else if ((num1 == 2) && (num == 3)) {
//				System.out.println("사용자 : 바위, 컴퓨터 : 보 \n졌습니다.");
//			}
//
//			if ((num1 == 3) && (num == 1)) {
//				System.out.println("사용자 : 보, 컴퓨터 : 가위 \n졌습니다.");
//
//			} else if ((num1 == 3) && (num == 2)) {
//				System.out.println("사용자 : 보, 컴퓨터 : 바위 \n이겼습니다.");
//
//			} else if ((num1 == 3) && (num == 3)) {
//				System.out.println("사용자 : 보, 컴퓨터 : 보 \n비겼습니다.");
//			}
		}

		sc.close();
	}
}
