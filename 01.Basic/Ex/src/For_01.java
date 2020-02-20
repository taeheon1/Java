public class For_01 {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			if (i == 2) {
				System.out.print("x");
			} else {
				System.out.print(" ");
				
			}
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			if ((i >=1  && i <= 3)) {
				System.out.print("x");
			} else {
				System.out.print(" ");
			}
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {

			System.out.print("x");
		}
		System.out.println();

			for (int j = 0; j < 5; j++) {
				if ((j >=1  && j <= 3)) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}

			}
		}
	}


//   x
//  xxx
// xxxxx
//  xxx
//   x