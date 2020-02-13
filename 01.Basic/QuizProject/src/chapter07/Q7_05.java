package chapter07;

import java.util.Scanner;

public class Q7_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3;
		while (true) {
			System.out.println("숫자 세개를 입력하세요.");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			if ((n3 > 0) && (n3 < 5)) {
				break;
			}
		}

		switch (n3) {
		case 1:
			System.out.println(sum(n1, n2));
			break;
		case 2:
			System.out.println(sub(n1, n2));
			break;
		case 3:
			System.out.println(mul(n1, n2));
			break;
		case 4:
			System.out.println(div(n1, n2));
			break;
		}
	}

	public static int sum(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}

	public static int sub(int n1, int n2) {
		int sub = n1 - n2;
		return sub;
	}

	public static int mul(int n1, int n2) {
		int mul = n1 * n2;
		return mul;
	}

	public static int div(int n1, int n2) {
		int div = n1 / n2;
		return div;
	}
}
/*세 개의 정수를 입력 받아서 앞의 두 수는 연산에 이용하고 세 번째 수는 연산자로 사용한다.
세번째 인수가 1이면 +, 2이면 -, 3이면 *, 4이면 / 연산을 한다. 
그 외의 수가 들어오면 다시 전체 입력을 받는다.
각 각의 연산은 메서드로 만들어 호출한다*/