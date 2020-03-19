import java.util.Scanner;

public class ThreadMain {

	public static void main(String[] args) {
		System.out.println("숫자를 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();
		int n_num = Integer.parseInt(s_num);

		try {
			Thread tsub = new ThreadSub(n_num);
			tsub.start();

		} catch (Exception e) {
			System.out.println("예외:" + e);
		}
		System.out.println("이름을 입력해 주세요.");
		String s_name = s.nextLine();
	}
}
