
public class Array {

	public static void main(String[] args) {
		// int형 1, 2, 3, 4를 쓸꺼임.
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println("\n밑은 배열");
		
		int[] arr = new int[4];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		
		int[] arr1 = {1, 2, 3, 4};
		int[] arr2 = {a, b, c, d};
		
		for(int i = 0; i < 4; i++) {
			System.out.println(arr[i]);
		}

	}

}
