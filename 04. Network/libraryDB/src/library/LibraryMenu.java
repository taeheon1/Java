package library;

class LibraryMenu {

	void showMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("[메뉴 선택]");
		System.out.println("1.책관리");
		System.out.println("2.회원관리");
		System.out.println("3.대여관리");
		System.out.println("4.프로그램종료");
		System.out.print("선택 : ");
	}

	void showBookMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("[메뉴 선택]");
		System.out.println("1.책 등록");
		System.out.println("2.책 조회");
		System.out.println("3.책 리스트 전체조회");
		System.out.println("4.책정보 삭제");
		System.out.println("5.책수량 수정");
		System.out.println("q : 뒤로가기");
		System.out.print("선택 : ");
	}

	void showUserMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("[메뉴 선택]");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.회원조회");
		System.out.println("4.전체회원조회");
		System.out.println("5.블랙리스트추가");
		System.out.println("6.블랙리스트삭제");
		System.out.println("7.전체블랙리스트조회");
		System.out.println("q : 뒤로가기");
		System.out.print("선택 : ");
	}

	void showRentMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("[메뉴 선택]");
		System.out.println("1.대여");
		System.out.println("2.반납");
		System.out.println("3.반납일 연장");
		System.out.println("q : 뒤로가기");
		System.out.print("선택 : ");
	}

	void showReturnMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("[메뉴 선택]");
		System.out.println("1.대여목록조회");
		System.out.println("2.책 반납");
		System.out.println("q : 뒤로가기");
		System.out.print("선택 : ");
	}
}