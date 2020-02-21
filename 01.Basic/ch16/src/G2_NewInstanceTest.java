import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Book2 {
	private String title;

	public Book2() {
	}

	public Book2(String title) {
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}
}

public class G2_NewInstanceTest {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Book2 myBook1 = new Book2("홍길동전");
		System.out.println(myBook1);

		Class pClass = Class.forName("Book2");
		Book2 myBook2 = (Book2) pClass.newInstance();
		myBook2.setTitle("전우치전");
		System.out.println(myBook2);
	}
}
//new 키워드를 사용하지 않고 클래스 정보를 활용하여 인스턴스를 생성하는 메서드
//new를 사용하여 객체를 만드는 방법 newInstance();