// enhanced for 문의 사용

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A4_IteratorCollection {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();

		// 인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Box");

		// 반복자 획득
		Iterator<String> itr = list.iterator();

		// 반복자를 이용한 순차적 참조
		while (itr.hasNext())
			System.out.print(itr.next() + '\t');

		System.out.println();

		// 반복자 다시 획득
		itr = list.iterator();

		// "Box"의 삭제
		String str;
		while (itr.hasNext()) {
			str = itr.next();

			if (str.equals("Box"))
				itr.remove();
		}

		// 반복자 다시 획득
		itr = list.iterator();

		// 삭제 후 결과 확인
		while (itr.hasNext())
			System.out.print(itr.next() + '\t');

		System.out.println();
	}
}