import java.util.Arrays;
import java.util.stream.Stream;

public class B1_StringStream {

	public static void main(String[] args) {
		String[] names = { "YOON", "LEE", "PARK" };

		// 스트림 생성
		Stream<String> stm = Arrays.stream(names);

		// 최종 연산 진행
		stm.forEach(s -> System.out.println(s));
	}
}

//forEach : 요소를 하나씩 꺼내 옴