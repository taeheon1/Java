import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer4 {
	static ServerSocket serverSocket = null;
	static Socket socket = null;
	static PrintWriter out = null;
	static BufferedReader in = null; // 주어진 문자 입력 스트림 in에 대해 기본 크기의 버퍼를 갖는 객체생성.
	static String s = "";

	// 생성자
	public MultiServer4() {

	}

	public static void init() {
		try {
			serverSocket = new ServerSocket(9999); // 소켓 객체 생성
			System.out.println("서버가 시작되었습니다.");

			socket = serverSocket.accept();
			// 연결된 원격 어드레스의 정보를 보여준다.
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			// 연결이 시작된 네트워크 인터페이스와 포트를 알려준다.
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (in != null) {
				s = in.readLine(); // 한줄을 읽는다. 문자읽기를 더 효율적으로 할수 있게됨
				if (s == null)
					break;
				if (s.equals("q") || s.equals("Q"))
					break;
				System.out.println(s);
				// out.println(s);
				sendAllMsg(s);
			}
			System.out.println("Bye...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();

				socket.close();
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 접속된 모든 클라이언트들에게 메시지를 전달.
	public static void sendAllMsg(String msg) {
		try {
			out.println(msg);
		} catch (Exception e) {
			System.out.println("예외:" + e);
		}
	}

	public static void main(String[] args) {

		// 서버객체 생성.
		MultiServer4 ms = new MultiServer4();
		ms.init();
	}
}
