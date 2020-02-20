package Game;

import java.util.Random;
import java.util.Scanner;

public class HighLowGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int ran, a;

		while (true) {
			System.out.println("나는 지금 0부터 100 사이의 값 중에 하나를 생각하겠습니다.");
			System.out.println("당신은 그 숫자를 6회안에 맞추시면 됩니다.");
			ran = random.nextInt(101);
			for (int i = 0; i < 6; i++) {
				System.out.print("몇이라고 생각합니까? <0 to 100>  ");
				a = sc.nextInt();
				if (a > ran) {
					System.out.println(a + "는 제가 정한 숫자보다 큽니다.");
				} else if (a == ran) {
					System.out.println(a + "는 정답입니다. 축하합니다!");
					break;
				} else {
					System.out.println(a + "는 제가 정한 숫자보다 작습니다.");
				}
				System.out.println("[" + (5 - i) + "]" + "의 기회가 남았습니다.");
			}
			System.out.println("게임을 더 진행하시겠습니까? (y/n)");
			String str = sc.next();
			if (!str.equalsIgnoreCase("y")) {
				System.out.println("Good bye~");
				break;
			}
		}

	}

}
