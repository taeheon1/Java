package Game;

public class QuizAZ {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int a = (i * 10) + j;
				int b = (j * 10) + i;
				if ((a + b) == 99)
					System.out.println(a + " + " + b + " = " + "99");
			}
		}
	}
}

//다음 식을 만족하는 모든 A와 Z를 구하는 프로그램을 작성하라
//  AZ
// +ZA
//-----
// 99
//단, A와 Z는 서로다른 숫자이다.