package Game;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int comary[] = new int[3];
		int count = 1;
		while (true) {
			int com = ran.nextInt(900) + 100; // 100~999까지
			comary[0] = com / 100; // 백의자리
			comary[1] = (com / 10) % 10; // 십의자리
			comary[2] = com % 10; // 일의자리

			if ((comary[0] != comary[1]) && (comary[0] != comary[2]) && (comary[1] != comary[2]))
				break;

		}
		System.out.println("숫자로 하는 야구게임시작");

		while (true) {
			System.out.printf("세자리 숫자를 입력하세요.(%d회)\n", count);
			count++;
			int me = sc.nextInt();
			int meary[] = { (me / 100), ((me / 10) % 10), (me % 10) };
			System.out.println(meary[0] + " : " + meary[1] + " : " + meary[2]);

			int strike = 0;
			int ball = 0;

			for (int i = 0; i < comary.length; i++) {
				for (int j = 0; j < meary.length; j++) {
					if (comary[i] == meary[i]) {
						strike++;

						break;
					} else if (comary[i] == meary[j]) {
						ball++;
					}
				}
			}
			System.out.println(strike + "Strike   " + ball + "Ball");

			if (strike == 3) {
				System.out.println("win!");
				break;
			} else if ((strike == 0) && (ball == 0)) {
				System.out.println("OUT!");
			}

		}

	}
}
//중복되지 않는 3개의 정수를 생성한다.
//사용자는 3개의 숫자를 입력한다.
//생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
//숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
//숫자는 맞지만 위치가 틀렸다면 ball로 판정한다.
//숫자3개가 모두 일치하지 않으면  out으로 판정한다.
//3 strike 가 되면 게임은 종료된다.
//시도한 횟수를 표시한다.
