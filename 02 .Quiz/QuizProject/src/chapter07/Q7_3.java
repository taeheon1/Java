package chapter07;

public class Q7_3 {

	public static void main(String[] args) {
		summin(3,2,1);
		summin(1,3,2);
		summin(2,1,3);

	}

	public static void summin(int num1,int num2,int num3) {
		
		if((num1<num2)&&(num1<num3)){
			System.out.println(num1);
			return;
		}
		else if((num2<num1)&&(num2<num3)) {
			System.out.println(num2);
			return;
		}
		else {
			System.out.println(num3);
			return;
		}
	}
}

//세 개의 정수를 인자로 전달 받아서 
//그중 가장 작은 수를 반환하는 함수를 정의하라 