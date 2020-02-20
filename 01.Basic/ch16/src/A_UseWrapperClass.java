
public class A_UseWrapperClass {

	public static void main(String[] args) {
		String a = "34";
		int b = 50;
		int c = Integer.parseInt(a);  // 문자열과 수치는 계산할 수 없다
		int d = c + b;				  // 문자열을 수치로 변환한다.	

		System.out.println(a + " + " + b + " + " + d);

	}

}




