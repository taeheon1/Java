import java.util.Arrays;

public class Arraysort {

	public static void main(String[] args) {
		int[] arr = { 3, 18, 9, 12, 77, 36 };
		System.out.println("정렬 전");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		// 버블정렬
		System.out.println("버블정렬 후");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) { // arr.length - i 인 이유는 : i 반복문이 돌때마다 
													  //제일 큰 값이 맨 뒤로 가기 때문
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		int[] arr1 = { 3, 18, 9, 12, 77, 36 };
		System.out.println("정렬 전");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Array sort 정렬 후");
		Arrays.sort(arr1);
		for (int p : arr1) {
			System.out.print(p + "\t");
		}
		
		
	}

}
