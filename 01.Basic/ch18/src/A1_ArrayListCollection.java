import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A1_ArrayListCollection {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		// 인스턴스 저장 : 순서 잇슴. 중복 허용.
		list.add("Toy");
		list.add("Box");
		list.add("Box");
		list.add("Robot");

		// 인스턴스 참조
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
//		Collections.sort(list);

		// 첫 번째 인스턴스 삭제
		list.remove(0);

		// 삭제 후 인스턴스 참조
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + '\t');
		System.out.println();
		
	}
}
