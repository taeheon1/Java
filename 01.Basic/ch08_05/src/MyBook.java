//생성자는 오브젝트 생성과 함께 자동적으로 호출되는 특수한 메서드이다.
//생성자는 클래스 이름과 같은 메서드명을 가진다.
//생성자는 메서드 이지만 리턴형이 없다.
//디폴트 생성자(파라미터 없는 애)는 자동으로 생성된다.
//파라미터 있는 생성자를 만들면 (오버로딩하면)
//디폴트 생성자가 자동으로 생성되지 않는다.
class Book
{
	int price;
	int num = 0;
	String title;
	
	Book()
	{
		title = "자바 프로그래밍";
		price = 5000;
	}
	
	Book(String t, int p)
	{
		title = t;
		price = p;
	}
	
	void print()
	{
		System.out.println("제   목 : " + title);
		System.out.println("가   격 : " + price);
		System.out.println("주문수량 :" +num);
		System.out.println("합계금액 :" +price *num);
	}
}
public class MyBook {

	public static void main(String[] args) {
		
		Book book1 = new Book();
		book1.print();
	
		Book book2 = new Book("자바 디자인패턴",10000);
		book2.num = 10;
		book2.print();

	}

}
