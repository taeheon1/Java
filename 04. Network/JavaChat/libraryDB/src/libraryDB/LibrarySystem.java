package libraryDB;

import java.util.Scanner;
import java.sql.*;

public class LibrarySystem {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	Connection con;
	PreparedStatement pstmt1;
	PreparedStatement pstmt2;
	PreparedStatement pstmt3;
	PreparedStatement pstmt4;
	Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("[메뉴 선택]");
		System.out.println("1.책 등록");
		System.out.println("2.책 조회");
		System.out.println("3.전체 리스트 조회");
		System.out.println("4.낡은 책 버리기");
		System.out.println("5.회원관리");
		System.out.print("선택 : ");
	}

	public void addBook() {
		System.out.print("책 번호 : ");
		String booknum = sc.nextLine();
		System.out.print("책 제목 : ");
		String bookname = sc.nextLine();
		System.out.print("등록할 권수 : ");
		String bookcount = sc.nextLine();

		String sql = "insert into Book values(?, ?, ?)";

		try {
			pstmt1 = con.prepareStatement(sql);

			pstmt1.setString(1, booknum);
			pstmt1.setString(2, bookname);
			pstmt1.setString(3, bookcount);
			int updateCount = pstmt1.executeUpdate(); // updateCount 몇번 업데이트 되었나 확인
			System.out.println(updateCount);
			System.out.println("데이터베이스에 추가되었습니다. ");
			System.out.println("-------------------------");
		} catch (Exception e) {
			System.out.println("데이터베이스 입력 에러입니다.");
		}
	}

	public void selBook() {
		System.out.print("조회할 책이름  : ");
		String bookname = sc.nextLine();
		String sql = "select * from Book where bookname = ?";
		try {
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, bookname);
			ResultSet rs = pstmt2.executeQuery();
			if (rs.next()) {
				System.out.println("책 번호 : " + rs.getString("booknum"));
				System.out.println("책 제목 : " + rs.getString("bookname"));
				System.out.println("책 권수 : " + rs.getString("bookcount"));
			}else {
				System.out.println("해당 책이 없습니다.");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("알 수 없는 에러가 발생하였습니다. ");
		}
	}

	public void selAllBook() {
			String sql = "select * from Book";
			try {
				pstmt3 = con.prepareStatement(sql);
				ResultSet rs = pstmt3.executeQuery();
				while (rs.next()) {
					System.out.print("책 번호 : " + rs.getString("booknum") + " | ");
					System.out.print("책 제목 : " + rs.getString("bookname") + " | ");
					System.out.println("책 권수 : " + rs.getString("bookcount"));
				}
					rs.close();
			} catch (Exception e) {
				System.out.println("알 수 없는 에러가 발생하였습니다. ");
			}
		}
	

	public void delBook() {
		System.out.print("버릴 책이름 : ");
		String bookname = sc.nextLine();

		String sql = "delete from Book where bookname = ?";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setString(1, bookname);
			int updateCount = pstmt4.executeUpdate();
			System.out.println(updateCount);
			System.out.println("데이터베이스에서 삭제되었습니다. ");
			System.out.println("--------------------------");
		} catch (Exception e) {
			System.out.println("데이터베이스 삭제 에러입니다. ");
		}
	}
	
	public void userShow() {
		System.out.println("1.회원가입");
	}
	
	

	public static void main(String[] args) {

		LibrarySystem mb = new LibrarySystem();
		mb.doRun();

	}

	public void doRun() {
		connectDatabase();
		int choice;
		while (true) {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				selBook();
				break;
			case 3:
				selAllBook();
				break;
			case 4:
				delBook();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}

	public void connectDatabase() {
		try {
			String jdbc_driver = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(jdbc_driver, "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
