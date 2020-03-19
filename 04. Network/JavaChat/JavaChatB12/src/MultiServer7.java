import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiServer7 {
	ServerSocket serverSocket = null; // 클라이언트에 요청을 받기위한 준비
	Socket socket = null; // 서버에 접속을 요청.
	Map<String, PrintWriter> clientMap;

	// 생성자
	public MultiServer7() {
		// 클라이언트의 출력스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();
		// 해쉬맵 동기화 설정.
		Collections.synchronizedMap(clientMap);
	}

	public void init() {
		try {
			serverSocket = new ServerSocket(9999); // 9999포트로 서버생성
			System.out.println("서버가 시작되었습니다.");
			while (true) {
				socket = serverSocket.accept(); // client 접속 accept
				// 연결된 원격 어드레스의 정보를 보여준다.
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread mst = new MultiServerT(socket); // 쓰레드 생성.
				mst.start(); // 쓰레드 시동.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 접속자 리스트 보내기
	public void list(PrintWriter out) {
		// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator<String> it = clientMap.keySet().iterator();
		String msg = "사용자 리스트 [";
		while (it.hasNext()) {
			msg += (String) it.next() + ",";
		}
		msg = msg.substring(0, msg.length() - 1) + "]";
		try {
			out.println(msg);
		} catch (Exception e) {
		}
	}

	// 접속된 모든 클라이언트들에게 메시지를 전달.
	public void sendAllMsg(String user, String msg) {
		// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				if (user.equals(""))
					it_out.println(msg);
				else
					it_out.println("[" + user + "]" + msg);
			} catch (Exception e) {
				System.out.println("예외:" + e);
			}
		}
	}

	public static void main(String[] args) {

		// 서버객체 생성.
		MultiServer7 ms = new MultiServer7();
		ms.init();
	}

	/////////////////////////////////////////////////
	// 내부 클래스
	// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드

	class MultiServerT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;

		// 생성자.
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				// 연결이 시작된 네트워크 인터페이스와 포트를 알려준다.
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// InputStreamReader : byte 단위로 들어오는 InputStream에 대하여
				// char 단위로 읽고쓰는 Reader 인터페이스를 제공해 주는 보조스트림
			} catch (Exception e) {
				System.out.println("예외:" + e);
			}
		}

		// 쓰레드를 사용하기 위해서 run()메서드 재정의
		@Override
		public void run() {
			// String s = "";
			String name = ""; // 클라이언트로부터 받은 이름을 저장할 변수.
			try {
				name = in.readLine(); // 클라이언트에서 처음으로 보내는 메시지는
										// 클라이언트가 사용할 이름이다.

				sendAllMsg("", name + "님이 입장하셨습니다.");
				// 현재 객체가 가지고있는 소켓을 제외하고 다른 소켓(클라이언트)들이게 접속을 알림.
				clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
				System.out.println("현재 접속자 수는" + clientMap.size() + "명 입니다.");

				// 입력스트림이 null이 아니면 반복.
				String s = "";
				while (in != null) {
					s = in.readLine();
					System.out.println(s);

					if (s.equals("/list"))
						list(out);
					else
						sendAllMsg(name, s);
				}
				// System.out.println("Bye...");

			} catch (Exception e) {
				System.out.println("예외:" + e);
			} finally {
				// 예외가 발생할때 퇴장. 해쉬맵에서 해당데이터 제거.
				// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
				clientMap.remove(name);
				sendAllMsg("", name + "님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
				try {
					in.close();
					out.close();

					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// 접속된 모든 클라이언트들에게 메시지를 전달.
		/////////////////////////////////////////////////////////////
	}
}
