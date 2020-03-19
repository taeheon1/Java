import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static void main(String[] args) throws IOException {
		new ChatServer();
	}
	
	final int SERVER_PORT = 5000;
	ServerSocket serverSocket = null;
	Socket socket = null;
	List<PrintWriter> list = null;
	ChatServerThread cst;

	ChatServer() {
		list = new ArrayList<>();
		try {
			// 서버 소켓 객체 생성
			serverSocket = new ServerSocket();

			// 소켓을 호스트의 포트와 binding
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(serverIP, SERVER_PORT));
			System.out.println("IP : " + serverIP + ", PORT : " + SERVER_PORT);

			// 요청 대기
			while (true) {
				socket = serverSocket.accept(); // 연결 요청이 오기 전까지는 block 상태
				cst = new ChatServerThread(socket, list);
				cst.start();
				InetSocketAddress remoteSocket = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteIP = remoteSocket.getAddress().getHostAddress();
				int remotePort = remoteSocket.getPort();
				String remoteHostName = remoteSocket.getAddress().getHostName();
//				String[] IPPORT = String.valueOf(socket.getLocalSocketAddress()).substring(1).split(":");
				System.out.println("[ChatServer " + Thread.currentThread().getId() + "] connected! IP : " + remoteIP
						+ ", PORT : " + remotePort + ", HOSTNAME : " + remoteHostName);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}