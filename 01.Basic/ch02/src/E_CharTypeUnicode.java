
public class E_CharTypeUnicode {

	public static void main(String[] args) {
		char ch1 = '헐';
		char ch2 = 'Ȯ';
		
		char ch3 = 54736;		//문자 '헐'의 유니코드 값 : 10진수
		char ch4 = 54869;		//문자 '확' 의 유니코드 값
		
		char ch5 = 0xD5D0;		//문자 ' 헐'의 유니코드 값 : 16진수
		char ch6 = 0xD655;
		
		char ch7 = 'A';
		
		System.out.println(ch1 + " " + ch2);
		System.out.println(ch3 + " " + ch4);
		System.out.println(ch5 + " " + ch6);
		System.out.println(ch7 + 32);
		System.out.println(ch7 + " " + (char)(ch7 + 32));

	}

}
