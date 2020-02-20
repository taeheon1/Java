import java.util.Scanner;

public class Case_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			if(a==0) {
				System.out.println("종료합니다");
				break;
			}
			switch (a) {
			case 12:
			case 1:
			case 2:
				System.out.println("겨울");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("여름");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("가을");
				break;
			default:
				System.out.println("없는계절");
				break;
			}
		}
	}
}

//12,1,2 겨울  3,4,5 봄 6,7,8 여름 9,10,11 이 가을일 때
//입력한 값에 따라서 계절표시 switch case