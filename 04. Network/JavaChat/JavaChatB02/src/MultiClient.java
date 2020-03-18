/*�ܼ� ��Ƽä�� Ŭ���̾�Ʈ ���α׷� */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {

	public static void main(String[] args) {
		System.out.println("�̸��� �Է��� �ּ���.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		PrintWriter out = null;
		BufferedReader in = null;

		try {
			// String ServerIP = "localhost";
			Socket socket = new Socket(args[0], 9999); // ���� ��ü ����
			System.out.println("������ ������ �Ǿ����ϴ�........");

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out.println(s_name);

			System.out.println("Receive : " + in.readLine());

			in.close();
			out.close();

			socket.close();
		} catch (Exception e) {
			System.out.println("����[MultiClient class]:" + e);
		}
	}
}
