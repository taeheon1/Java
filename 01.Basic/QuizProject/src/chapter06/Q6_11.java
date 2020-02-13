package chapter06;

public class Q6_11 {

	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		
		do {
			
			i++;
			if(i%2 ==0) {
				sum=sum+i;
			}
		
		}while(i<101);
		
		System.out.printf("값=%d",sum);
		
	}
}
