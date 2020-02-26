enum Scale1 {
	DO, RE, MI, FA, SO, RA, TI,
}

public class A3_SimpleEnum {

	public static void main(String[] args) {
		Scale1 sc = Scale1.DO;
		System.out.println(sc);

		switch (sc) {
		case DO:
			System.out.println("도~");
			break;
		case RE:
			System.out.println("레~");
		case MI:
			System.out.println("미~");
		case FA:
			System.out.println("파~");
		case SO:
			System.out.println("솔~");
		case RA:
			System.out.println("라~");
		case TI:
			System.out.println("시~");
		default:
			System.out.println("솔~ 라~ 시~ ");
		}
	}
}
//case 문에서는 표현의 간결함을 위해 DO와 같이 '열거형 값'의 이름만
//명시하기로 약속되어있다.