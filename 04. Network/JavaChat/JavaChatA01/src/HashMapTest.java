import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		// Map<Ű, ���> -> Ű�� �ߺ��� ������� ����
		// Ű�� �ߺ��� ��� ���� ����

		Map<String, String> map = new HashMap<>();
		map.put("��ȭ", "�����޺� ŰŰ");
		map.put("ȣ��", "��ũ��");
		map.put("��ȭ", "Ȳȥ���� ��������");

		System.out.println(map);
		System.out.println();

		String key;
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			key = (String) it.next();
			System.out.println(map.get(key));
		}

		map.put("��ȭ", "����...."); // ������ Ű�� ���� �����Ѵ�.
		System.out.println(map);
		System.out.println();
	}
}