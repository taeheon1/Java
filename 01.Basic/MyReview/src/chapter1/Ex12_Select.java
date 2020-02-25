package chapter1;

public class Ex12_Select {

	public static void main(String[] args) {
		for (int a = 5; a <= 8; a++) {
			System.out.println(a + "/3 = " + a / 3);
			switch (a % 3) {
			case 1:
				System.out.println(" : 나머지는 1입니다.");
				break;
			case 2:
				System.out.println(" : 나머지는 2입니다.");
				break;
			default:
				System.out.println(" : 나머지는 0입니다.");
				break;
			}
		}
	}
}
