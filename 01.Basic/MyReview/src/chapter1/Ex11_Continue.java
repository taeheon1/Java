package chapter1;

public class Ex11_Continue {

	public static void main(String[] args) {
		int a, b = 1;
//		System.out.println(a);

		for (a = 0; a < 4; a++) {
			if (a + b == 2) {
				continue;
			}
			System.out.println(a + "+" + b + "=" + (a + b));
		}
	}
}
