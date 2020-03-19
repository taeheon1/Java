package chat_ProtoType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Login extends JFrame implements ActionListener {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setFont(new Font("D2Coding", Font.PLAIN, 22));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanel jp1, jp2;
	private JLabel jlb1;
	private JTextField jt1;
	private JButton sendbtn;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		// 창 크기 설정 및 가운데 위치
		setSize(300, 110);
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		Dimension d = tk.getScreenSize();
//		int screenHeight = d.height;
//		int screenWidth = d.width;
//		setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
		setLocationRelativeTo(null); // 윈도우 가운데 놓기
		setResizable(false); // 사이즈 조정 금지

		// 컨테이너 설정
		Container ctn = getContentPane();
		ctn.setBackground(new Color(0xD5D5D5));
		ctn.setLayout(new BorderLayout());

		jp1 = new JPanel(new BorderLayout());
		jp1.setBackground(new Color(0xD5D5D5));
		jp2 = new JPanel(new BorderLayout());
		jp2.setBackground(new Color(0xD5D5D5));

		jlb1 = new JLabel("닉네임");
		jlb1.setFont(new Font("D2Coding", Font.BOLD, 24));
		jt1 = new JTextField(10);
		jt1.setFont(new Font("돋움", Font.PLAIN, 22));
		// 엔터키 누르면 로그인
		jt1.registerKeyboardAction(this, "Login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED); // (this, getActionCommand명, 지정키, 언제)

		sendbtn = new JButton("Login");
		sendbtn.setFont(new Font("D2Coding", Font.PLAIN, 20));
		sendbtn.setBackground(Color.BLACK);
		sendbtn.setForeground(Color.WHITE);
		sendbtn.addActionListener(this);

		jp1.add(jlb1, BorderLayout.CENTER);
		jp1.add(jt1, BorderLayout.EAST);
		jp2.add(sendbtn, BorderLayout.CENTER);

		ctn.add(jp1, BorderLayout.NORTH);
		ctn.add(jp2, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane msg = new JOptionPane();
		msg.setFont(new Font("D2Coding", Font.PLAIN, 24));
		if (jt1.getText().equals("")) {
			msg.showMessageDialog(null, "닉네임을 입력해주세요.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.dispose();
		new ClientChat().call(jt1.getText());
	}
}