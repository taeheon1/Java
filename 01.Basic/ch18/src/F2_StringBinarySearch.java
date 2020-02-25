import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class F2_StringBinarySearch {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");

		// 정렬
		Collections.sort(list);

		// 탐색
		int idx = Collections.binarySearch(list, "Robot");

		// 탐색 결과 출력
		System.out.println(list.get(idx));

	}

}
