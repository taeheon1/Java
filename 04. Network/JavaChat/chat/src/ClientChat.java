import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientChat extends JFrame implements ActionListener {

	/**
	 * Create the frame.
	 */
//	private static final String SERVER_IP = "192.168.0.2";
	private static final String SERVER_IP = "192.168.219.115";
	private static final int SERVER_PORT = 5000;
	private Socket socket = null;
	private JPanel jp1, jp2, jp3;
	private JLabel jlb1, jlb2;
	private JTextArea chat;
	private JTextField text;
	private JScrollPane sp;
	private JButton sendbtn;
	private String nick = "";

	// 서버에서 받는 메소드
	Thread tr = new Thread() {
		public void run() {
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while (true) {
					String msg = br.readLine();
					String[] code = msg.split("!::!");
					if (code[0].equals("!usermethod!")) {
						if (code[1].equals("join")) {
							jlb2.setText("인원수 : " + code[3] + "명 ");
						} else if (code[1].equals("quit")) {
							jlb2.setText("인원수 : " + code[3] + "명 ");
						}
					} else {
						chat.append(msg);
						chat.append("\n");
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	};

	public ClientChat() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Chatting Room");

		// 창 종료시 종료메소드 보냄
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				PrintWriter pw;
				try {
					pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
							true);
					String request = "quit\n";
					pw.println(request);
					System.exit(0);
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});

		// 창 크기 설정 및 가운데 위치
		setSize(600, 700);
		setLocationRelativeTo(null);
		setResizable(false);

		// 컨테이너 설정
		Container ctn = getContentPane();
		ctn.setBackground(new Color(0xD5D5D5));
		ctn.setLayout(new BorderLayout());

		jp1 = new JPanel(new BorderLayout(0, 0)); // 맨위
		jp2 = new JPanel(new BorderLayout(0, 0)); // 채팅창
		jp3 = new JPanel(new BorderLayout(10, 10)); // 텍스트, 버튼

		jlb1 = new JLabel(" KOSMO 채팅방");
		jlb1.setFont(new Font("D2Coding", Font.BOLD, 20));
		jlb2 = new JLabel("인원수 : 0명 ");
		jlb2.setFont(new Font("D2Coding", Font.BOLD, 20));

		chat = new JTextArea(20, 25) {
			{
				setOpaque(false); // 투명도
				setEditable(false); // 수정 불가능
				setText("");
				setFont(new Font("D2Coding", Font.BOLD, 20));
				setForeground(Color.BLACK);
			}
		};

		sp = new JScrollPane(chat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		text = new JTextField(10);
		text.setFont(new Font("굴림", Font.PLAIN, 16));
		text.setSize(350, 40);
		// 엔터키 누르면 보내는 메소드
		text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMsg();
				}
			}
		});

		sendbtn = new JButton("보내기");
		sendbtn.setFont(new Font("D2Coding", Font.PLAIN, 18));
		sendbtn.setBackground(Color.BLACK);
		sendbtn.setForeground(Color.WHITE);
		sendbtn.addActionListener(this);

		jp1.add(jlb1, BorderLayout.WEST);
		jp1.add(jlb2, BorderLayout.EAST);
		jp2.add(sp, BorderLayout.CENTER);
		jp3.add(text, BorderLayout.CENTER);
		jp3.add(sendbtn, BorderLayout.EAST);

		ctn.add(jp1, BorderLayout.NORTH);
		ctn.add(jp2, BorderLayout.CENTER);
		ctn.add(jp3, BorderLayout.SOUTH);
	}

	void call(String nick) {
		this.nick = nick;
		this.setVisible(true);
		try {
			connetServer();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void connetServer() throws IOException {
		socket = new Socket();
		socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
				true);
		tr.start();
		System.out.println("connected...");
		String request = "join!::!" + nick + "\n";
		pw.println(request);
		JOptionPane.showMessageDialog(null, "채팅방에 입장하였습니다.");
	}

	// 쓰레드를 만들어서 대화를 보내기
	public void sendMsg() {
		String msg = text.getText();
		if (msg.equals("")) {
			JOptionPane.showMessageDialog(null, "글을 입력하세요.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			chat.requestFocus();
			return;
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			String request = "message!::!" + msg + "\n";
			pw.println(request);
			text.setText("");
			sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum()); // 스크롤 맨아래로
//			chat.setCaretPosition(chat.getDocument().getLength());
			text.requestFocus();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("보내기")) {
			sendMsg();
		}
	}
}