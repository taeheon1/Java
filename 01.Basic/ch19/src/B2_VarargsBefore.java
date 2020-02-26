// 가변 인자 
public class B2_VarargsBefore {
	public static void showAll(String[] vargs) {
		System.out.println("LEN: " + vargs.length);

		for (String s : vargs)
			System.out.print(s + '\t');
		System.out.println();
	}

	public static void main(String[] args) {
		showAll(new String[] { "Box" });
		showAll(new String[] { "Box", "Toy" });
		showAll(new String[] { "Box", "Toy", "Apple" });
	}
}