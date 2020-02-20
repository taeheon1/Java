package chapter13;

import java.util.Scanner;

public class Q13_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("입력하세요");
		String str = sc.nextLine();
		int len = str.length();
		boolean a = false;
		String[] ar = new String[len];
		
		for(int i = 0; i < len; i++) {
			System.out.println(str.substring(i,i+1));
			System.out.print(ar[i]);
		}
		
		String[] arr2 = new String[len];
		for(int i=0; i<len; i++) {
			arr2[len-1-i] = ar[i];
			
		}
		
		if (a) {
			System.out.print(str + "은 회문입니다.");
		} else {
			System.out.print(str + "은 회문이 아닙니다.");
		}

	}

}
