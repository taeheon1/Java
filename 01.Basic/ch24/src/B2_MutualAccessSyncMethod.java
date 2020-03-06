//쓰레드의 메모리 접근 방식과 그에 따른 문제점
class Counter2 {
	private int count = 0;
	
	synchronized public void increment() {
		count++;
	}
	
	synchronized public void decrement() {
		count--;
	}
	
	public int getCount() { return count; }
}

public class B2_MutualAccessSyncMethod {
	public static Counter2 cnt = new Counter2();
	
	public static void main(String[] args) 
			throws InterruptedException
			{
				Runnable task1 = () -> {
					for(int i = 0; i<1000; i++)
						cnt.increment();
				};
				
				Runnable task2 = () -> {
					for(int i = 0; i<1000; i++)
						cnt.decrement();
				};
				
				Thread t1 = new Thread(task1);
				Thread t2 = new Thread(task2);
				
				t1.start();
				t2.start();
				
				t1.join(); // t1이 참조하는 쓰레드의 종료를 기다림
				t2.join(); // t2가 참조하는 쓰레드의 종료를 기다림
				
				//쓰레드가 종료되면 출력을 진행함. 위 join 의 영향
				System.out.println(cnt.getCount());

	}
}
