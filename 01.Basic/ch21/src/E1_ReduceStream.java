import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
//배열에 여러 문자열이 있을 때 길이가 가장 긴 문자열 찾기
public class E1_ReduceStream {

	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Box", "Simpel", "Complex", "Robot");

		BinaryOperator<String> lc = (s1, s2) -> {
			if (s1.length() > s2.length())
				return s1;
			else
				return s2;
		};

		String str = ls.stream().reduce("", lc); // reduce메소드 : 최종으로 남은애 ex) 가장 XX한
		// reduce(초기값, 요소); 초기값까지도 포함되어 연산됌
		// ex) reduce("AAAAAAAA", lc); 면 AAAAAAAA이 나옴

		System.out.println(str);
	}
}