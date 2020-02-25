package chapter3.ex33;

abstract class Calc {
	int a;
	int b;

	abstract void answer();

	void setData(int m, int n) {
		a = m;
		b = n;
	}
}

class Plus extends Calc {
	void answer() {
		System.out.println(a + "+" + b + "=" + (a + b));
	}
}

class Sub extends Calc {
	void answer() {
		System.out.println(a + "-" + b + "=" + (a - b));
	}
}

public class Calculation {

	public static void main(String[] args) {
		Plus plus = new Plus();
		plus.setData(27, 32);
		plus.answer();
		plus.setData(33, 55);
		plus.answer();

		Sub sub = new Sub();
		sub.setData(10, 5);
		sub.answer();

	}

}
