package step01;

public class MyphoneBook {

	public static void main(String[] args) {
		PhoneInfo pInfo1 = new PhoneInfo("손오공", "010-1234-5678", "test1@test.com");
		PhoneInfo pInfo2 = new PhoneInfo("전우치", "010-4321-8765");
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
		
	}

}

//여러 개의 데이터를 보관하기 위해”[
//1.PhoneInfo 클래스 만들기
//2.메인 메뉴 구성하기
//3.연락처 입력 동작시키기 → 콜렉션 객체에 데이터 추가
//4.연락처 출력하기 → 조회기능
//5.연락처 삭제하기
//6.프로그램 종료시 연락처 저장하기
//7.프로그램 시작시 연락처 로드하기
