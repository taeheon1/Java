package chapter06;

public class Q6_13 {

	public static void main(String[] args) {
		
		int i,j;
		System.out.println("가로");
		for(j=1; j<10; j++) {
			for(i=2; i < 10; i++) {
				System.out.print(i + " x " + j + " = " +(i*j)+  "    " );
			if(i==9) {
				System.out.println();
			}
		}
	}
		
		System.out.println("세로");
		for(i=2; i<10; i++) {
			for(j=1; j<10; j++) {
				System.out.print(i + " x " + j + " = " +(i*j)+  "    " );
			if(j==9) {
				System.out.println();
			  }

			}
			
		}
		
		

	}

}
