package chapter06;

public class Q6_4 {

	public static void main(String[] args) {
		int sum = 1;
		int result = 0;
		int a = 0;
		do {
			if(sum==1000) {
				System.out.print(sum+" = ");
			}else
			System.out.print(sum+" + ");
			
			result += sum;
			sum++;
			
			a++;
			if(a==100) {
				System.out.println();
				a = 0;
			}
		} while(sum <= 1000);
		System.out.print(result);
	}
	
}

//Do~While문을 이용하여 1~1000까지 더해서 결과를 출력하는 프로그램을 작성하시오.
//실행결과도 아래와같이 출력하시오.
//예)1+2+3.......+1000 = 500500
