//쓰레드 - 프로그램 내에서 실행의 흐름을 이루는 최소의 단위
public class A1_CurrentThreadName {

	public static void main(String[] args) {
		Thread ct = Thread.currentThread();
		String name = ct.getName();
		System.out.println(name);

	}
}
