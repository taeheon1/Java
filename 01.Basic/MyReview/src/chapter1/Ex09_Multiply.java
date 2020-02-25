package chapter1;

public class Ex09_Multiply {

	public static void main(String[] args) {
		int i, j;

		for (j = 2; j <= 9; j++) {
			for (i = 1; i <= 9; i++) {
				System.out.println(j + "x" + i + "=" + j * i);
			}
			System.out.println("-------------------");
		}
	}
}
