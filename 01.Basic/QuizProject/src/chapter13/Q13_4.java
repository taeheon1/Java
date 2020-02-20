package chapter13;

import java.util.Scanner;

public class Q13_4 {

	public static void main(String[] args) {
		int[] ar = new int[10];
		Scanner sc = new Scanner(System.in);
		int fir = 0;
		int las = ar.length - 1;

		for (int i = 0; i < ar.length; i++) {
			System.out.print("정수입력 : ");
			int a = sc.nextInt();
			if (a % 2 == 0) {
				ar[las--] = a;
				//las--;
				
			} else {
				ar[fir++] = a;
				//fir++;
			}
		}
		
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}

	}

}
