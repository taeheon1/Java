package chat_ProtoType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	private static int num = 0;
	private String nick = "";
	private Socket socket = null;
	List<PrintWriter> list = null;
	private String user = "!usermethod!!::!";

	ChatServerThread(Socket socket, List<PrintWriter> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
			while (true) {
				String request = br.readLine();
				if (request == null) {
					System.out.println("클라이언트로부터 연결 끊김");
					break;
				}

				String[] code = request.split("!::!");
				if (code[0].equals("join")) {
					join(code[1], pw);
				} else if (code[0].equals("message")) {
					msg(code[1]);
				} else if (code[0].equals("quit")) {
					quit(pw);
				}
			}
		} catch (IOException e) {
			System.out.println(this.nick + "님이 채팅방을 나갔습니다.");
		}
	}

	private void join(String nick, PrintWriter pw) {
		this.nick = nick;
		num++;

		String data = nick + "님이 입장하였습니다.";
		send(data);

		// writer pool에 저장
		addWriter(pw);

		data = user +"join!::!" + nick + "!::!" + num;
		send(data);
	}

	private void quit(PrintWriter pw) {
		removeWriter(pw);
		num--;

		String data = this.nick + "님이 퇴장했습니다.";
		send(data);

		data = user + "quit!::!" + this.nick + "!::!" + num;
		send(data);
	}

	private void msg(String msg) {
		send(this.nick + " : " + msg);
	}

	private void addWriter(PrintWriter pw) {
		synchronized (list) {
			list.add(pw);
		}
	}

	private void removeWriter(PrintWriter pw) {
		synchronized (list) {
			list.remove(pw);
		}
	}

	private void send(String msg) {
		synchronized (list) {
			for (PrintWriter pw : list) {
				pw.println(msg);
				pw.flush();
			}
		}
	}
}