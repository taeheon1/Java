package library.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class DBCommand {

	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt1;
	private PreparedStatement pstmt2;
	private PreparedStatement pstmt3;
	private PreparedStatement pstmt4;

	private String sql = "";

	public DBCommand() {
		DBConnection dbc = new DBConnection();
		con = dbc.connect();
	}

	// 책 정보 추가 메서드
	public void addBook(String booknum, String bookname, String bookcount) {
		sql = "insert into librarydb_Book values(?, ?, ?)";

		try {
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1, booknum);
			pstmt1.setString(2, bookname);
			pstmt1.setString(3, bookcount);
			int updateCount = pstmt1.executeUpdate(); // updateCount 몇번 업데이트 되었나 확인
			System.out.println("책 등록이 완료 되었습니다. ");
			System.out.println("-----------------------------------------------");
		} catch (SQLException se) {
			System.out.println("이미 있는 책번호입니다.");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 책 정보 조회메서드
	public int selBook(String bookname) {
		int bookcount = 0;
		boolean tf = true;
		try {
			Integer.valueOf(bookname);
			sql = "select * from librarydb_Book where booknum = ? or bookname = ?";
		} catch (NumberFormatException e) {
			sql = "select * from librarydb_Book where bookname = ?";
			tf = false;
		}
		try {
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, bookname);
			if (tf)
				pstmt2.setString(2, bookname);
			rs = pstmt2.executeQuery();
			if (rs.next()) {
				System.out.println("-----------------------------------------------");
				System.out.println("책 번호 : " + rs.getString("booknum"));
				System.out.println("책 제목 : " + rs.getString("bookname"));
				bookcount = Integer.valueOf(rs.getString("bookcount"));
				System.out.println("책 권수 : " + bookcount);
			} else {
				System.out.println("해당 책이 없습니다.");
			}
			System.out.println();
			rs.close();
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
		return bookcount;
	}

	// 모든 책정보 조회 메서드
	public void selAllBook() {
		sql = "select * from librarydb_Book order by booknum";
		try {
			pstmt3 = con.prepareStatement(sql);
			rs = pstmt3.executeQuery();
			while (rs.next()) {
				System.out.println("-----------------------------------------------");
				System.out.print("책 번호 : " + rs.getString("booknum") + " | ");
				System.out.print("책 제목 : " + rs.getString("bookname") + " | ");
				System.out.println("책 권수 : " + rs.getString("bookcount"));
			}
			System.out.println("-----------------------------------------------");
			rs.close();
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 책 삭제 메서드
	public void delBook(String booknum) {
		sql = "delete from librarydb_Book where booknum = ?";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setString(1, booknum);
			int updateCount = pstmt4.executeUpdate();
			if (updateCount > 0) {
				System.out.println("-----------------------------------------------");
				System.out.println("책이 사라졌습니다. ");
			} else {
				System.out.println("-----------------------------------------------");
				System.out.println("데이터베이스에 등록되지 않은 책입니다.");
			}
			System.out.println("-----------------------------------------------");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 책 수량 수정 메서드
	public boolean cModBook(String booknum, int bookcount) {
		boolean tf = false;
		sql = "update librarydb_Book set bookcount = ? where booknum = ?";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setInt(1, bookcount);
			pstmt4.setString(2, booknum);
			int updatecount = pstmt4.executeUpdate();
			if (updatecount > 0) {
				System.out.println("-----------------------------------------------");
				System.out.println("책수량이 수정되었습니다. ");
				tf = true;
			} else {
				System.out.println("-----------------------------------------------");
				System.out.println("데이터베이스에 등록되지 않은 책입니다.");
			}
			System.out.println("-----------------------------------------------");
		} catch (SQLException se) {
			System.out.println("이미 있는 데이터입니다.");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
		return tf;
	}

	// 회원가입 메서드
	public void signUp(String user_id, String user_name) {

		sql = "insert into librarydb_user values(user_num.nextval, ?, ?, ?)";

		try {
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, user_id);
			pstmt2.setString(2, user_name);
			pstmt2.setString(3, "");
			int updateCount = pstmt2.executeUpdate();
			System.out.println("-----------------------------------------------");
			System.out.println("회원가입이 완료되었습니다. ");
			System.out.println("-----------------------------------------------");
		} catch (SQLException se) {
			System.out.println("이미 있는 데이터입니다.");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 회원탈퇴 메서드
	public void delUser(String userid) {

		sql = "delete from librarydb_user where user_id = ?";
		try {
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setString(1, userid);
			int updateCount = pstmt3.executeUpdate();
			if (updateCount > 0) {
				System.out.println("-----------------------------------------------");
				System.out.println("회원정보가 삭제되었습니다. ");
			} else {
				System.out.println("-----------------------------------------------");
				System.out.println("데이터베이스에 등록되지 않은 회원입니다.");
			}
			System.out.println("-----------------------------------------------");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 회원조회 메서드
	public String serUser(String users) {
		String userid = "";
		sql = "select * from librarydb_user where user_id = ? or user_name = ? order by user_id";

		try {
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setString(1, users);
			pstmt3.setString(2, users);
			rs = pstmt3.executeQuery();
			System.out.println();
			System.out.println("[조회하신 회원정보]");
			while (rs.next()) {
				System.out.println("-----------------------------------------------");
				System.out.println("회원번호 : " + rs.getString("user_num"));
				userid = rs.getString("user_id");
				System.out.println("회원아이디 : " + userid);
				System.out.println("회원이름 : " + rs.getString("user_name"));
				if (rs.getString("user_black") != null) {
					System.out.println("블랙리스트여부 : " + rs.getString("user_black"));
				}
			}
			System.out.println("-----------------------------------------------");
			System.out.println();
			if (!rs.isFirst()) {
				System.out.println("없는 회원정보 입니다.");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
		return userid;
	}

	// 모든회원 검색메서드
	public void serAlluser() {
		sql = "select * from librarydb_user order by user_num";
		try {
			pstmt3 = con.prepareStatement(sql);
			rs = pstmt3.executeQuery();
			while (rs.next()) {
				System.out.println("-----------------------------------------------");
				System.out.print("회원번호 : " + rs.getString("user_num") + " | ");
				System.out.print("회원아이디 : " + rs.getString("user_id") + " | ");
				System.out.print("회원이름 : " + rs.getString("user_name"));
				if (rs.getString("user_black") != null) {
					System.out.print(" | 블랙리스트여부 : " + rs.getString("user_black"));
				}
				System.out.println();
				System.out.println("-----------------------------------------------");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 블랙추가 메서드
	public void blackAdd(String users, String num) {

		LocalDate today = LocalDate.now();
		LocalDate rtd = today.plusDays(Integer.valueOf(num));

		sql = "update LIBRARYDB_USER set user_black = ? where USER_ID = ?";

		try {
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setDate(1, Date.valueOf(rtd));
			pstmt3.setString(2, users);
			int updateCount = pstmt3.executeUpdate();
			if (updateCount > 0) {
				System.out.println("-----------------------------------------------");
				System.out.println("블랙리스트에 추가되었습니다. ");
			} else {
				System.out.println("회원정보가 없습니다. 다른 회원 ID를 입력하세요");
			}
			System.out.println("-----------------------------------------------");
		} catch (SQLException se) {
			System.out.println("이미 있는 데이터입니다.");
		} catch (NumberFormatException ne) {
			System.out.println("공백이 들어올수 없습니다.");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 블랙삭제 메서드
	public void blackDel(String users) {

		sql = "update LIBRARYDB_USER set user_black = ? where USER_ID = ?";

		try {
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setDate(1, null);
			pstmt3.setString(2, users);
			int updatecount = pstmt3.executeUpdate();
			if (updatecount > 0) {
				System.out.println("-----------------------------------------------");
				System.out.println("블랙리스트에서 삭제되었습니다. ");
			} else {
				System.out.println("회원정보가 없습니다. 다른 회원 ID를 입력하세요");
			}
			System.out.println("-----------------------------------------------");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("이미 있는 데이터입니다.");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 블랙리스트 전체조회
	public void blackSer() {
		sql = "select * from librarydb_user where user_black is not null";
		try {
			pstmt4 = con.prepareStatement(sql);
			rs = pstmt4.executeQuery();
			if (rs.next()) {
				rs = pstmt4.executeQuery();
				while (rs.next()) {
					System.out.println("-----------------------------------------------");
					System.out.print("회원번호 : " + rs.getString("user_num") + " | ");
					System.out.print("회원아이디 : " + rs.getString("user_id") + " | ");
					System.out.print("회원이름 : " + rs.getString("user_name") + " | ");
					System.out.println("블랙리스트기간 : " + rs.getString("user_black"));
				}
			} else {
				System.out.println("-----------------------------------------------");
				System.out.println("블랙리스트가 없습니다");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 에러");
		}
	}

	// 대여처리 메서드
	public String rentBook(String booknum, String userid, String date) {
		LocalDate today;
		int bookcount = selBook(booknum);
		int bookcount1 = bookcount - 1;
		if (selBook(booknum) <= 0) {
			return "책 수량이 부족합니다.";
		}
		if (serUser(userid).equals("")) {
			return "등록되어있지 않은 회원아이디 입니다. \n다시입력해주세요.";
		}

		if (date.equals("")) {
			today = LocalDate.now();
		} else {
			today = LocalDate.parse(date);
		}
		cModBook(booknum, bookcount1); // 책수량 메서드, 책수량 1 감소
		LocalDate rtd = today.plusDays(7);
		String ret = String.valueOf(rtd) + "까지 반납\n" + "책 수량 " + bookcount + "권 에서 " + bookcount1 + "권 으로 변경완료.";

		sql = "insert into librarydb_rent values(rent_num.nextval, ?, ?, ?, ?, 'X')";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setString(1, booknum);
			pstmt4.setString(2, userid);
			pstmt4.setDate(3, Date.valueOf(today));
			pstmt4.setDate(4, Date.valueOf(rtd));
			pstmt4.executeUpdate();
			System.out.println("정상적으로 대여되었습니다. ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 에러");
		}
		return ret;
	}

	// 1주일 연장 메서드
	public String returnExtend(String booknum, String userid) {
		if (serUser(userid).equals("")) {
			return "등록되어있지 않은 회원아이디 입니다.";
		}
		LocalDate today = LocalDate.now();
		LocalDate rtd = today.plusDays(7);
		String ret = String.valueOf(rtd) + " 까지 반납 연장되었습니다.";

		sql = "update LIBRARYDB_RENT set RENT_RETURNDATE = ? where RENT_BOOKNUM = ? and RENT_ID = ? and RENT_OX = 'X' ";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setDate(1, Date.valueOf(rtd));
			pstmt4.setString(2, booknum);
			pstmt4.setString(3, userid);
			pstmt4.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 에러");
		}
		return ret;
	}

	// 미반납자 전체목록 메서드
	public void selReturn() {
		sql = "select * from LIBRARYDB_RENT where RENT_OX = 'X'";
		try {
			pstmt4 = con.prepareStatement(sql);
			rs = pstmt4.executeQuery();
			System.out.println();
			System.out.println("미반납자목록");
			System.out.println("-----------------------------------------------");
			while (rs.next()) {
				System.out.print("책번호 : " + rs.getString("RENT_BOOKNUM") + " | ");
				System.out.print("회원아이디 : " + rs.getString("RENT_ID") + " | ");
				System.out.print("반납예정날짜 : " + rs.getString("RENT_RETURNDATE"));
				System.out.println();
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 에러");
		}
	}

	// 반납 처리메서드
	public String returnBook(String booknum, String userid) {
		int bookcount = selBook(booknum);
		int bookcount1 = bookcount + 1;
		if (serUser(userid).equals("")) {
			return "등록되어있지 않은 회원아이디 입니다.";
		}
		cModBook(booknum, bookcount1);
		LocalDate today = LocalDate.now();
		String ret = String.valueOf(today) + " 반납 완료되었습니다.";
		LocalDate returndate = LocalDate.now(); // 반납날짜를 저장하기위해 날짜변수 초기화

		sql = "select RENT_RETURNDATE from LIBRARYDB_RENT where RENT_BOOKNUM = ? and RENT_ID = ? and RENT_OX = 'X'";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setString(1, booknum);
			pstmt4.setString(2, userid);
			rs = pstmt4.executeQuery();
			if (rs.next()) {
				returndate = rs.getDate("RENT_RETURNDATE").toLocalDate(); // 반납날짜를 변수에 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "update LIBRARYDB_RENT set RENT_OX = 'O' where RENT_BOOKNUM = ? and RENT_ID = ? and RENT_OX = 'X' ";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setString(1, booknum);
			pstmt4.setString(2, userid);
			pstmt4.executeUpdate();
			System.out.println(bookcount + "권에서 " + bookcount1 + "권으로 책수량 변경완료.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 에러");
		}

		// 연체되면 블랙리스트 처리
		Period delay = Period.between(returndate, today); // 반납날짜의 차이에 따라 블랙처리
		if (delay.getDays() > 0) { // 반납예정일 - 반납일 = 양수(연체) => delay * 2
			blackAdd(userid, String.valueOf((delay.getDays() * 2)));
		} else {
			System.out.println("정상 반납 하였습니다.");
		}
		return ret;
	}

	// 자동으로 블랙리스트 제거 메서드
	public void blackAutoMod() {
		LocalDate today = LocalDate.now();

		sql = "update LIBRARYDB_USER set user_black = ? where USER_BLACK < ?";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setDate(1, null);
			pstmt4.setDate(2, Date.valueOf(today));
			pstmt4.executeUpdate();
		} catch (SQLException se) {
			System.out.println("이미 있는 데이터입니다.");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}

	// 자동으로 블랙리스트 추가 메서드
	public void blackAutoAdd() {
		LocalDate today = LocalDate.now();
		List<String> list = new ArrayList<>();

		sql = "SELECT RENT_ID FROM LIBRARYDB_RENT WHERE RENT_OX = 'X' AND RENT_RETURNDATE < ?";

		try {
			pstmt4 = con.prepareStatement(sql);
			pstmt4.setDate(1, Date.valueOf(today));
			rs = pstmt4.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("RENT_ID"));
			}
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					sql = "update LIBRARYDB_USER set USER_BLACK = ? where USER_ID = ?";
					pstmt4 = con.prepareStatement(sql);
					pstmt4.setDate(1, Date.valueOf(today.plusDays(1)));
					pstmt4.setString(2, list.get(i));
					pstmt4.executeUpdate();
				}
			}
		} catch (SQLException se) {
			System.out.println("데이터베이스 에러!");
		} catch (Exception e) {
			System.out.println("데이터베이스 에러");
		}
	}
}