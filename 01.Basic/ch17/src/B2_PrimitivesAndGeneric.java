//기본 자료형에 대한 제한 그리고 래퍼 클래스
class Box8<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		return ob;
	}
}

public class B2_PrimitivesAndGeneric {

	public static void main(String[] args) {
		Box8<Integer> iBox = new Box8<Integer>();

		iBox.set(125); // 오토 박싱 진행
		int num = iBox.get(); // 오토 언박싱 진행

		System.out.println(num);
	}
}
