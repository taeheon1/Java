package chapter13;

public class Q13_2 {

	public static void main(String[] args) {
		char[] ar = new char[] { 'G', 'o', 'o', 'd', ' ', 't', 'i', 'm', 'e' };
		String str = "";
		for (int i = 0; i < ar.length; i++) {
			str += ar[i];
		}
		System.out.println(str);
	}

}

//char형 1차원 배열을 선언과 동시에 
//'Good time' 문장으로 초기화하고, 저장된 내용을 출력하라