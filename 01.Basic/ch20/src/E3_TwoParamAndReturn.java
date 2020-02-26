//매개변수가 있고 반환하는 람다
interface Calculate4 {
	int cal(int a, int b);
}

public class E3_TwoParamAndReturn {

	public static void main(String[] args) {
		Calculate4 c;
		c = (a, b) -> { return a + b; };
		// int num = c.cal(4,3); //이와 같이 연산 결과가 남는다.
		System.out.println(c.cal(4, 3));

		c = (a, b) -> a + b;
		System.out.println(c.cal(4, 3));

	}
}
//중괄호 안의 구현부가 한 문장이라도 return 문은 중괄호 생략을 할  수 없다.

//다만, 중괄호 안의 구현부가 반환문 하나라면 return 과 중괄호 모두 생략 가능하다.