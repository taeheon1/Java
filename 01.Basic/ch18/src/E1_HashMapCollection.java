import java.util.HashMap;

public class E1_HashMapCollection {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();

		// key-value 기반 데이터 저장
		map.put(45, "Brown");
		map.put(37, "James");
		map.put(45, "Martin");

		// 데이터 탐색
		System.out.println("23번 :" + map.get(23));
		System.out.println("37번 :" + map.get(37));
		System.out.println("45번 :" + map.get(45));
		System.out.println();

		// 데이터 삭제
		map.remove(37);

		// 데이터 삭제 확인
		System.out.println("37번 :" + map.get(37));

	}

}

//K = key V = value
//Key 값은 중복이 되면 안된다. 데이터는 중복이 되도 된다.
//검색에선 제일 빠르다. 모든 데이터를 쉽게 쓰기 위한 방법