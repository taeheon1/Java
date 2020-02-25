package chapter1;

public class Ex10_Break {

	public static void main(String[] args) {
		int a, b = 2;
//		System.out.println(a);

		for (a = 0; a < 5; a++) {
			if (b - a <= 0) {
				break;
			}
			System.out.println(b + "-" + a + "=" + (b - a));
		}
	}
}
