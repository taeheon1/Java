package chapter06;
import java.util.Scanner;
public class Q6_9 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("정수입력 : ");
		int i = sc.nextInt();
		
		 {
			for(int j=9; j>=1; j--)
			System.out.println(i +"x"+j+"="+(i*j));
		}
		sc.close();
	}
	

}
/*사용자로부터 정수 하나를 입력받은 후
 *  그 수에 해당하는 구구단을 역순으로 출력하시오.	
 */