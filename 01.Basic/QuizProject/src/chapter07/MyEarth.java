package chapter07;

class 엘프 { // 설계도
	String 이름;
	int 나이;

	엘프() { // 생성자
	}
	
	엘프(int n) {
		나이 = n;
	}

	boolean 활쏘기() {
		boolean 명중 = false;
		// 활이 날아가서 부딪히는 동작 구현
		// 그리고 체크
		if (명중) {
			System.out.println("쏘면 명중 !");
			return true;
		} else {
			System.out.println("불발ㅜㅜ");
			return false;
		}
	}
}

public class MyEarth {

	public static void main(String[] args) {
		엘프 test1 = new 엘프(); // Object 변수
		test1.이름 = "홍길동";
		test1.나이 = 25;
		boolean bCheck = test1.활쏘기();
		if (bCheck) {
			// 점수 올리기 처리
		}
	}
}