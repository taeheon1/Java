import java.util.Scanner;

public class Case_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grd = sc.nextInt();

		switch (grd / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
			break;
		}
	}
}

// 입력한 성적이 90점 이상이면 A 80 이상 B 70 이상 C 그외는 D 단, 스위치문을 사용하라