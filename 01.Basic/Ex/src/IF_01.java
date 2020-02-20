import java.util.Scanner;

public class IF_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grd = sc.nextInt();
		
		if (grd >= 90) {
			System.out.println("A");
		} else if (grd >= 80) {
			System.out.println("B");
		} else if (grd >= 70) {
			System.out.println("C");
		} else {
			System.out.println("D");
		}
			
	}
}

//입력한 성적이 90점 이상이면 A 80 이상 B 70 이상 C 그외는 D