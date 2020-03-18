package step09;

//csv 형태
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class MyphoneBook {

	static Scanner sc = new Scanner(System.in);
	static Map<String, PhoneInfo> map = new HashMap();

	public static void showMenu() {
		System.out.println("[ 메뉴 선택 ]");
		System.out.println("1. 전화번호 입력");
		System.out.println("2. 전화번호 조회");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 종료");
		System.out.print("선택 : ");
	}

	public static void addNumber() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();

		PhoneInfo pInfo;
		if (email != null) {
			pInfo = new PhoneInfo(name, phoneNumber, email);
		} else {
			pInfo = new PhoneInfo(name, phoneNumber);
		}
		pInfo.showPhoneInfo();
		map.put(name, pInfo);
		System.out.println("맵의 크기  : " + map.size());
	}

	public static void selNumber() {
		System.out.print("조회할 이름 : ");
		String name = sc.nextLine();
		PhoneInfo pInfo = map.get(name);
		if (pInfo != null) {
			System.out.println("---------------------------");
			System.out.println("조회되었습니다.");
			pInfo.showPhoneInfo();
		} else {
			System.out.println("해당 값이 없습니다.");
		}
//		 Set<String> ks = map.keySet();
//		 for(String s : ks)
//			 System.out.println(map.get(s).toString());
//		 System.out.println("-------------------------------");
	}

	public static void delNumber() {
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();

		PhoneInfo pInfo = map.remove(name);
		if (pInfo != null) {
			System.out.println("---------------------------");
			System.out.println("삭제되었습니다.");
			pInfo.showPhoneInfo();
		} else {
			System.out.println("해당 값이 없습니다.");
		}
		// map에 남아있는 리스트 확인
//		 Set<String> ks = map.keySet(); 
//		 for(String s : ks)
//			 System.out.println(map.get(s).toString());
//		 System.out.println("-------------------------------");
	}

	public static void readInfo() {
		try (BufferedReader br = new BufferedReader(new FileReader("phone_data.csv"))) {
			String str;

			while (true) {
				str = br.readLine();
				if (str == null)
					break;

				StringTokenizer sToken = new StringTokenizer(str, "\",\"");
				String name = sToken.nextToken();
				String phoneNumber = sToken.nextToken();
				String email = null;
				if (sToken.hasMoreTokens()) {
					email = sToken.nextToken();
//					System.out.println("["+email+"]");
				}

				PhoneInfo pInfo;
				if (email != null) {
					pInfo = new PhoneInfo(name, phoneNumber, email);
				} else {
					pInfo = new PhoneInfo(name, phoneNumber);
				}
				// pInfo.showPhoneInfo();
				map.put(name, pInfo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readInfo();
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
}
