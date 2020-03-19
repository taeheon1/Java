import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

//서버로 메시지를 전송하는 클래스
public class Receiver3 extends Thread {

	Socket socket;
	BufferedReader in = null;

	// Socket을 매개변수로 받는 생성자.
	public Receiver3(Socket socket) {
		this.socket = socket;

		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (Exception e) {
			System.out.println("예외1:" + e);
		}
	}

	// run()메소드 재정의
	@Override
	public void run() {
		while (in != null) {
			try {
				System.out.println("Thread Receive : " + in.readLine());
			} catch (Exception e) {
				System.out.println("예외2:" + e);
			}
		}

		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3:" + e);
		}
	}

}
