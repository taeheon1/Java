package library;

import java.util.Scanner;
import java.util.regex.Pattern;

import library.db.DBCommand;

public class LibrarySystem {

	private Scanner sc = new Scanner(System.in);
	private DBCommand dbcm = new DBCommand();
	private LibraryMenu menu = new LibraryMenu();
	private String choice;

	private void doRun() {
		while (true) {
			dbcm.blackAutoMod();
			menu.showMenu();
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				bookMenu();
				break;
			case "2":
				userMenu();
				break;
			case "3":
				rentMenu();
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	private void bookMenu() {
		while (true) {
			menu.showBookMenu();
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			case "1":
				addBook();
				break;
			case "2":
				selBook();
				break;
			case "3":
				dbcm.selAllBook();
				break;
			case "4":
				delBook();
				break;
			case "5":
				cModBook();
				break;
			case "q":
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	private void addBook() {
		System.out.print("책 번호 : ");
		String booknum = sc.nextLine();
		System.out.print("책 제목 : ");
		String bookname = sc.nextLine();
		System.out.print("등록할 권수 : ");
		String bookcount = sc.nextLine();
		dbcm.addBook(booknum, bookname, bookcount);
	}

	private void selBook() {
		System.out.print("조회할 책이름 또는 책번호 : ");
		String bookname = sc.nextLine();
		dbcm.selBook(bookname);
	}

	private void delBook() {
		System.out.print("삭제할 책번호 : ");
		String booknum = toNum();
		dbcm.delBook(booknum);
	}

	private void cModBook() {
		System.out.print("수정할 책 번호 : ");
		String booknum = toNum();
		System.out.print("몇권으로 수정하시겠습니까 ? ");
		String bookcount = toNum();
		int bookcount1 = dbcm.selBook(booknum);
		if (dbcm.cModBook(booknum, Integer.valueOf(bookcount))) {
			System.out.println("책번호 " + booknum + "이(가) " + bookcount1 + "권에서 " + bookcount + "권으로 변경되었습니다.");
		}
	}

	private void userMenu() {
		while (true) {
			menu.showUserMenu();
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			case "1":
				signUp();
				break;
			case "2":
				delUser();
				break;
			case "3":
				serUser();
				break;
			case "4":
				dbcm.serAlluser();
				break;
			case "5":
				blackAdd();
				break;
			case "6":
				blackDel();
				break;
			case "7":
				dbcm.blackSer();
				break;
			case "q":
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	private void signUp() {
		System.out.print("회원아이디 : ");
		String userid = sc.nextLine();
		System.out.print("회원이름 : ");
		String username = sc.nextLine();
		dbcm.signUp(userid, username);
	}

	private void delUser() {
		System.out.print("삭제할 회원아이디 : ");
		String userid = sc.nextLine();
		dbcm.delUser(userid);
	}

	private void serUser() {
		System.out.print("조회할 회원ID 또는 회원명 : ");
		String users = sc.nextLine();
		dbcm.serUser(users);
	}

	private void blackAdd() {
		System.out.print("블랙리스트에 추가할 회원ID : ");
		String users = sc.nextLine();
		System.out.print("블랙리스트에 추가할 일 수 :  ");
		String num = toNum();
		dbcm.blackAdd(users, num);
	}

	private void blackDel() {
		System.out.print("블랙리스트에 삭제할 회원ID : ");
		String users = sc.nextLine();
		dbcm.blackDel(users);
	}
	
	private void rentMenu() {
		while (true) {
			menu.showRentMenu();
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			case "1":
				rentBook();
				break;
			case "2":
				returnMenu();
				break;
			case "3":
				returnExtend();
				break;
			case "q":
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	private void rentBook() {
		System.out.print("대여할 책번호 : ");
		String booknum = sc.nextLine();
		System.out.print("대여자아이디 : ");
		String userid = sc.nextLine();
		System.out.println(dbcm.rentBook(booknum, userid));
	}

	private void returnExtend() {
		System.out.print("대여했던 책번호 : ");
		String booknum = sc.nextLine();
		System.out.print("대여자아이디 : ");
		String userid = sc.nextLine();
		System.out.println(dbcm.returnExtend(booknum, userid));
	}

	private void returnMenu() {
		while (true) {
			menu.showReturnMenu();
			choice = sc.nextLine();
			switch (choice.toLowerCase()) {
			case "1":
				dbcm.selReturn();
				break;
			case "2":
				returnBook();
				break;
			case "q":
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	private void returnBook() {
		System.out.print("반납할 책번호 : ");
		String booknum = sc.nextLine();
		System.out.print("대여자아이디 : ");
		String userid = sc.nextLine();
		System.out.println(dbcm.returnBook(booknum, userid));
	}

	private String toNum() {
		String num;
		while (true) {
			num = sc.nextLine();
			if ((Pattern.matches("^[0-9]*$", num))) {
				break;
			} else {
				System.out.println("숫자가 아닙니다. 숫자만 입력해주세요");
			}
		}
		return num;
	}

	public static void main(String[] args) {
		LibrarySystem mb = new LibrarySystem();
		mb.doRun();
	}
}