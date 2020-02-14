
public class C1_BuildString {

	public static void main(String[] args) {
		StringBuilder stbuf = new StringBuilder("123");

		stbuf.append(45678);
		System.out.println(stbuf.toString()); //추가

		stbuf.delete(0, 2);
		System.out.println(stbuf.toString()); //0~2까지 삭제

		stbuf.replace(0, 3, "AB");
		System.out.println(stbuf.toString()); //12345678 = 0~2까지 123 버리고
											  //3 의 자리에 AB를 덮는다	AB678
		stbuf.reverse();
		System.out.println(stbuf.toString()); //역순으로 출력 876BA

		String sub = stbuf.substring(2, 4);   // 876BA 에서 2~3까지 출력
		System.out.println(sub);

	}

}

