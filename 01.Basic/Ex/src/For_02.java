
public class For_02 {

	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if ((i == 1 || i == 5) && (j != 3)) {
					System.out.print(" ");
					continue;
				} else if ((i == 2 || i == 4) && (j < 2 || j > 4)) {
					System.out.print(" ");
					continue;
				} else {
					System.out.print("*");
					
				}
			}
			System.out.println();
		}

	}

}
