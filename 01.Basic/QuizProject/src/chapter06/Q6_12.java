package chapter06;
import java.util.Scanner;
public class Q6_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		System.out.print("정수 1 :");
		int a = sc.nextInt();
	    System.out.print("정수 2 :");
		int b = sc.nextInt();
		
		if(a > b) {
			for(int i = b ; i <= a ; i++) {
				result = result + i;
			}
		}
		else if(a == b)
			result = a + b;
		else
			for(int i = a ; i <= b ; i++) {
				result = result + i;
			}
			
		System.out.printf("결과 : %d", result);	

		sc.close();
	}

}
