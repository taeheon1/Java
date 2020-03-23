import java.util.Scanner;
import java.sql.*;

public class MyPhoneBook {
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
	Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("[메뉴 선택]");
		System.out.println("1.전화번호 입력");
		System.out.println("2.전화번호 조회");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.종료");
		System.out.print("선택 : ");
	}

	public void addNumber() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();

		String sql = "insert into PhoneBook values(?, ?, ?)";

		try {
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1, name);
			pstmt1.setString(2, phoneNumber);
			pstmt1.setString(3, email);
			int updateCount = pstmt1.executeUpdate(); 
			System.out.println(updateCount); // updateCount 몇번 업데이트 되었나 확인
			System.out.println("데이터베이스에 추가되었습니다. ");
			System.out.println("-------------------------");
		} catch (Exception e) {
			System.out.println("데이터베이스 입력 에러입니다.");
		}
	}

	public void selNumber() {
		System.out.print("조회할 이름 : ");
		String name = sc.nextLine();

		String sql = "select * from PhoneBook where name = ?";
		try {
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, name);
			ResultSet rs = pstmt2.executeQuery();
			if (rs.next()) {
				System.out.println("name : " + rs.getString("name"));
				System.out.println("phoneNumeber : " + rs.getString("phoneNumber"));
				if ((rs.getString("email")) != null) {
					System.out.println("email : " + rs.getString("email"));
				}
			} else {
				System.out.println("해당 값이 없습니다. ");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("알 수 없는 에러가 발생하였습니다. ");
		}
	}

	public void delNumber() {
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();

		String sql = "delete from PhoneBook where name = ?";

		try {
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setString(1, name);
			int updateCount = pstmt3.executeUpdate();
			System.out.println(updateCount);
			System.out.println("데이터베이스에서 삭제되었습니다. ");
			System.out.println("--------------------------");
		} catch (Exception e) {
			System.out.println("데이터베이스 삭제 에러입니다. ");
		}
	}

	public static void main(String[] args) {

		MyPhoneBook mp2 = new MyPhoneBook();
		mp2.doRun();

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
				addNumber();
				break;
			case 2:
				selNumber();
				break;
			case 3:
				delNumber();
				break;
			case 4:
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
