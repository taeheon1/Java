package chapter2.ex27;

public class MainParam {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("커맨드라인 인수가 없습니다.");
		} else {
			for (int i = 0; i < args.length; i++) {
				System.out.println((i + 1) + " : " + args[i]);
			}
		}
	}
}
