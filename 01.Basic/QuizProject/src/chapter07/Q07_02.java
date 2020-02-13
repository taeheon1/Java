package chapter07;

public class Q07_02 {

	public static void main(String[] args) {
		summax(1, 2, 3);
		summax(10, 9, 8);
		summax(4, 8, 5);
	}

	public static void summax(int num1, int num2, int num3) {

		if ((num1 > num2) && (num1 > num3)) {
			System.out.println(num1);
			return;
		} else if ((num2 > num1) && (num2 > num3)) {
			System.out.println(num2);
			return;
		} else {
			System.out.println(num3);
			return;
		}
	}
}

//세 개의 정수를 인자로 전달 받아서 
//그중 가장 큰 수를 반환하는 함수를 정의하라