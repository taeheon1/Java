//'매개변수화 타입' 을 '타입인자'로 전달
class Box9<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		return ob;
	}
}

public class B3_BoxInBox {

	public static void main(String[] args) {
		Box9<String> sBox = new Box9<>();
		sBox.set("I am so happy.");

		Box9<Box9<String>> wBox = new Box9<>();
		wBox.set(sBox);

		Box9<Box9<Box9<String>>> zBox = new Box9<>();
		zBox.set(wBox);

		System.out.println(zBox.get().get().get());
	}
}