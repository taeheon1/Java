package chapter13_2;

public class Q13_1 {

	public static void main(String[] args) {
		int[][] ar = new int[3][9];

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j] = (i + 2) * (j + 1);

			}
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print((i + 2) + " x " + (j + 1) + " = " + ar[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

//가로가 9, 세로가 3인 int형 2차원 배열을 선언하여 
//구구단 중 2, 3, 4단을 저장한다.
//그리고 제대로 저장이 되었는지 확인하기 위해 
//출력을 하는 프로그램을 작성하라
