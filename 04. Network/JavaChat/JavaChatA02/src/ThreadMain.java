import java.util.Scanner;

public class ThreadMain {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��� �ּ���.");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();
		int n_num = Integer.parseInt(s_num);

		try {
			Thread tsub = new ThreadSub(n_num);
			tsub.start();

		} catch (Exception e) {
			System.out.println("����:" + e);
		}
		System.out.println("�̸��� �Է��� �ּ���.");
		String s_name = s.nextLine();
	}
}
