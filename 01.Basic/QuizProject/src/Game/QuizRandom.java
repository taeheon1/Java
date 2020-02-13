package Game;

import java.util.Random;

public class QuizRandom {

	public static void main(String[] args) {
		Random random = new Random();
		int ran;
		while (true) {
			ran = random.nextInt(1000); 

			int a = ran / 100; // 백의자리
			int b = (ran / 10) % 10; // 십의자리
			int c = ran % 10; // 일의자리

			if ((a != b) && (a != c) && (b != c)) {
				System.out.printf("%d%d%d",a,b,c);
				break;
			} else {
				System.out.println(ran);
			}
		}
		System.out.println("세자리수 = " + ran);
	}
}

//랜덤한 세자리 수를 표시합니다.
//단 100의 자리와 수와 10의 자리의 수 1의 자리의 수는 같아서는 안됩니다.
//Ex ) 

//101 등 안됨 : 1이 두개임
//777 등 안됨 : 7이 세개임

//224 등 안됨 : 2가 두개임
//233 등 안됨 : 3이 두개임