package Game;

import java.util.Scanner;

public class MindReader {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0 부터 100 사이의 값 중에 하나를 생각하세요.");
		System.out.println("제(컴)가 제시한 숫자가 생각한 숫자보다 크면 h를 입력하세요.");
		System.out.println("제(컴)가 제시한 숫자가 생각한 숫자보다 작으면 l을 입력하세요.");
		System.out.println("제(컴)가 숫자를 맞췄다면 y를 입력해주세요.");

		int min = 0;
		int max = 100;
		int count = 0;

		while (true) {
			int num = min + ((max - min) / 2);
			System.out.println("당신이 선택한 숫자는 " + num + "입니까?");
			count++;
			String str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				System.out.println("정답입니다. " + count + "회차");
				break;
			} else if (str.equalsIgnoreCase("l")) {
				min = num;
			} else if (str.equalsIgnoreCase("h")) {
				max = num;
			}
		}
		System.out.println("굿바이~");
		
	}

}

//내가 생각한 숫자를 컴퓨터가 맞춘다.
//내가 생각한 숫자보다 크면 h 라고 입력한다.
//내가 생각한 숫자보다 작으면 l 이라고 입력한다.
//내가 생각한  숫자와 같으면 y 라고 입력한다.


//do-while문
//String str;
//do {
//	int num = min + ((max - min) / 2);
//	System.out.println("당신이 선택한 숫자는 " + num + "입니까?");
//	count++;
//	str = sc.next();
//	if (str.equalsIgnoreCase("l")) {
//		min = num;
//	} else if (str.equalsIgnoreCase("h")) {
//		max = num;
//	}
//} while(!str.equals("y"));
//System.out.println("정답입니다. " + count + "회차");
//System.out.println("굿바이~");
