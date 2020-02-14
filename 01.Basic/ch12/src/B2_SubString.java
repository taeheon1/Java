
//문자열의 일부 추출

public class B2_SubString {

	public static void main(String[] args) {
		String st1 = "동해물과백두산"; // 0,1,2,3,4,5,6,7 0~7까지 자리 0=동 ...7=산

		String st2 = st1.substring(4);
		System.out.println(st2);

		String st3 = st1.substring(0, 7); // 0부터 7까지
		System.out.println(st3);

	}

}
