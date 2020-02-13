package chapter07;

import java.util.Scanner;

public class Q7_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("섭씨 입력");
		int num1 = sc.nextInt();
		System.out.println("섭씨" + num1 + " = " + "화씨" + Cel(num1));
		System.out.println("화씨 입력");
		int num2 = sc.nextInt();
		System.out.println("화씨" + num2 + " = " + "섭씨" + Fah(num2));
	}

	public static int Cel(int num) {
		return (int) (1.8 * num + 32);
	}

	public static int Fah(int num) {
		return (int) ((num - 32) / 1.8);
	}
}

/* 섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 함수와
   화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.
   화씨 = 1.8 * 섭씨 + 32
   섭씨 = (화씨 - 32) / 1.8   
*/
