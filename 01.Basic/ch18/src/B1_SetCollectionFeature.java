import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class B1_SetCollectionFeature {

	public static void main(String[] args) {
		// Set 특징 : 중복 안됨, 저장순서가 없음.
		Set<String> set = new HashSet<>();
		set.add("Toy");
		set.add("Box");
		set.add("Robot");
		set.add("Box");
		
		System.out.println("인스턴스 수 : " + set.size());

		// 반복자를 이용한 전체 출력
		for (Iterator<String> itr = set.iterator(); itr.hasNext();)
			System.out.print(itr.next() + '\t');
		System.out.println();

		// for - each를 이용한 전체출력
		for (String s : set)
			System.out.print(s + '\t');
		System.out.println();
	}
}

//출력 결과를 통해 동일 인스턴스가
//저장되지 않음을 알 수 있다.
//그렇다면 동일 인스턴스의 기준은?