package chapter06;

public class Q6_11 {

	public static void main(String[] args) {
		int sum = 0;
		int num = 1;
		do {
			if(num%2==0) {
				sum+= num;
				}
				num++;
		}while(num<=100);
		System.out.println("짝수의 합 : " + sum);		
	}
	
}
//1부터 100까지 정수중에서 짝수의 합을 구하라. 단 do~while문을 이용하라