package chapter07;

public class Q7_01 {

	public static void main(String[] args) {
		avg(10, 10, 10);
		avg(100, 100, 100);
	}

	public static void avg(int num1, int num2, int num3) {
		System.out.println("평균 값 : " + (num1 + num2 + num3) / 3);
		return;
	}
}

//세 개의 정수를 인자로 전달 받아서 평균을 반환하는 함수 정의