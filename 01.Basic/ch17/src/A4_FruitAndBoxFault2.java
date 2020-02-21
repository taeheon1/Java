class Apple4 {
	public String toString() {
		return "I am an apple.";
	}
}

class Orange4 {
	public String toString() {
		return "I am an orange.";
	}
}

class Box4 {
	private Object ob;

	public void set(Object o) {
		ob = o;
	}

	public Object get() {
		return ob;
	}
}

public class A4_FruitAndBoxFault2 {

	public static void main(String[] args) {
		Box4 aBox = new Box4();
		Box4 oBox = new Box4();

		// 과일을 박스에 담은 것일까? (사과와 오렌지가 아닌 '문자열'을 담음
		aBox.set("Apple");
		oBox.set("Orange");

		System.out.println(aBox.get()); // Apple4, Orange4 클래스의 값을 출력한 것이 아니라
		System.out.println(oBox.get()); // String Apple, String Orange가 출력
	}
}
//불편함이라 하면 상자에서 물건을 꺼낼 때 형 변환을 해야한다는 것이고,
//문제점이라고 하면 프로그래머가 실수를 해도 그실수가 드러나지 않을 수도 있다는 것이다.


