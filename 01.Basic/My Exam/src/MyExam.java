//매개변수와 리턴 값 정리
public class MyExam {

	public static void main(String[] args) {
		// 파라미터 없고 반환 없는 메서드
		Hello();
		
		// 파라미터 있고 반환 없는 메서드
		MyAdd(1,2);
		
		// 파라미터 없고 반환 있는 메서드
		int temper = Temper();
		System.out.println(temper);
		System.out.println(Temper());
		
		// 파라미터 있고 반환 있는 메서드
		int sum = TwoNumAdd(1,2);
		System.out.println("합은" + sum);
	}
	public static int TwoNumAdd(int num1, int num2) {
		return num1 + num2;

	}
	public static int Temper() {
		return 16;
}
	public static void MyAdd(int num1, int num2) {
		int nResult = num1 + num2;
		System.out.println(nResult);
	}
		
		public static void Hello() {
			System.out.println("Hello");
    }
}