package Game;

import java.util.Random;
import java.util.Scanner;

public class game1 {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int my, com;

		while (true) {
			System.out.println("무엇을 내겠습니까 ?(1:가위 2:바위 3:보 0:종료) :");

			my = sc.nextInt();
			com = random.nextInt(3) + 1;

			if (my == 1) {
				System.out.print("사용자 : 가위, ");
				if (com == 1) {
					System.out.println("컴퓨터 : 가위");
					System.out.println("비겼습니다.");
				} else if (com == 2) {
					System.out.println("컴퓨터 : 바위");
					System.out.println("졌습니다.");
				} else {
					System.out.println("컴퓨터 : 보");
					System.out.println("이겼습니다.");
				}
			} else if (my == 2) {
				System.out.print("사용자 : 바위, ");
				if (com == 1) {
					System.out.println("컴퓨터 : 가위");
					System.out.println("이겼습니다.");
				} else if (com == 2) {
					System.out.println("컴퓨터 : 바위");
					System.out.println("비겼습니다.");
				} else {
					System.out.println("컴퓨터 : 보");
					System.out.println("졌습니다.");
				}
			} else if (my == 3) {
				System.out.print("사용자 : 보, ");
				if (com == 1) {
					System.out.println("컴퓨터 : 가위");
					System.out.println("졌습니다.");
				} else if (com == 2) {
					System.out.println("컴퓨터 : 바위");
					System.out.println("이겼습니다.");
				} else {
					System.out.println("컴퓨터 : 보");
					System.out.println("비겼습니다.");
				}
			} else if (my == 0) {
				System.out.println("*** 게임을 종료합니다 ***");
				break;
			} else {
				System.out.println("잘못입력하였습니다.");
			}
		}
	}
}
