// TCP/IP 프로토콜
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
	public static void main(String args[]) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String s = "";

		try {
			serverSocket = new ServerSocket(9999); //소켓 객체 생성
			System.out.println("서버가 시작되었습니다.");

			socket = serverSocket.accept();
			//연결된 원격 어드레스의 정보를 보여준다.
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			//연결이 시작된 네트워크 인터페이스와 포트를 알려준다.
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			s = in.readLine();
			System.out.println(s);
			out.println(s);

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
}