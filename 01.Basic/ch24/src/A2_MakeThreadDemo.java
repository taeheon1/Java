import javax.swing.table.TableColumn;
//쓰레드를 생성하는 방법
class Task extends Thread {
	public void run() {
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1 + n2));
	}
}
//1단계 Thread 를 상속하는 클래스의 정의와 인스턴스 생성
public class A2_MakeThreadDemo {

	public static void main(String[] args) {
		Task t1 = new Task();

		t1.start();

		System.out.println("End " + Thread.currentThread().getName());

	}
}
//2단계 쓰레드의 start 메소드 호출