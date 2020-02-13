package chapter06;
import java.util.Scanner;
public class Q6_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			System.out.printf("정수입력 %d 번째 : ", i+1);
	        int num = sc.nextInt();
	        if(num<1) {
	        	while(num<1) {
	        		System.out.printf("재입력 하세요 : ");
	        		num = sc.nextInt();
	        	}
	        }
	        sum = sum + num;
		}
	    
	
		System.out.printf("정수 의 합 = %d ",sum);
		
		sc.close();
		
		}
	}
		

/*사용자로부터 5개의 정수를 입력받아서 합을 구하여 출력한다.
만약 입력받는 숫자가 1미만의 숫자라면 재입력을 요구해야 한다. 
그래서 1이상의 정수 5개를 입력받아야 프로그램이 완성된다.
*/