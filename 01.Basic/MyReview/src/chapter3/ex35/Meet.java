package chapter3.ex35;

//인터페이스는 상속 관계가 아닌 클래스 기능을 제공하는 구조.
//클래스와 비슷한 구조이지만, 정의와 추상 메서드만이 멤버가 될 수 있다.
interface Greet {
	void greet();
}

interface Bye extends Greet {
	void bye();
}

class Greeting implements Bye {
	public void greet() {
		System.out.println("안녕하세요!");
	}

	public void bye() {
		System.out.println("안녕히 계세요.");
	}
}

public class Meet {

	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.greet();
		greeting.bye();
	}
}