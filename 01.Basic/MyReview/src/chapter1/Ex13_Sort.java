package chapter1;

public class Ex13_Sort {

	public static void main(String[] args) {
		// 배열 데이터 정렬하기
		int a[] = { 210, 19, 72, 129, 34 };
		int l = a.length;
		int i, j, k;

		System.out.println("정렬 전 데이터 표시 : ");

		for (i = 0; i < l; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
//-------------------------------------------------
		// 정렬 (작은 값을 앞으로 채워나감)
		for (j = 0; j < l - 1; j++) {
			for (i = j + 1; i < l; i++) {  
				if (a[j] > a[i]) {
					k = a[j];
					a[j] = a[i];
					a[i] = k;
				}
			}
		}
//-------------------------------------------------
		System.out.println("정렬 후 데이터 표시 : ");
		for (i = 0; i < l; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
}