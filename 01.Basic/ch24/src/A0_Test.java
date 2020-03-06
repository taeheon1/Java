class MyTest1 {
	public void print() {
		int num = 30;
		for (int i = 0; i < num; i++) {
			System.out.println("MyTest1 : " + i);
		}
	}
}

class MyTest2 {
	public void print() {
		int num = 30;
		for (int i = 0; i < num; i++) {
			System.out.println("MyTest2 : " + i);
		}
	}
}

public class A0_Test {

	public static void main(String[] args) {
		MyTest1 test1 = new MyTest1();
		MyTest2 test2 = new MyTest2();

		test1.print();
		System.out.println("=====================");
		test2.print();

	}
}
//이런 결과 떄매 쓰레드를 사용 
//쓰레드를 사용하면 동시에 결과를 출력할수 있다.