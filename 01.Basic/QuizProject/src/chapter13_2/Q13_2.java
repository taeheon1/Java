package chapter13_2;

public class Q13_2 {

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		int[][] arr2 = new int[4][2];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				arr2[j][i] = arr1[i][j];
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j]+"\t");
			}

			System.out.println();
		}

	}

}

//우선 아래와 같은 형태의 좌측배열 A를 선언한다. 
//그리고 A배열의 초기값을 이용해서 
//우측배열 B를 초기화하는 프로그램을 작성하시오
