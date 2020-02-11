class Book
{
	int price;
	String title;
	
	Book(String t, int p)
	{
		title = t;
		price = p;
	}
	
	//복제 생성자
	Book(Book copy)
	{
		title = copy.title;
		price = copy.price;
	}
	
	void print()
	{
		System.out.println("제   목 : " + title);
		System.out.println("가   격 : " + price);
	}
}

public class MyBook 
	{

	public static void main(String[] args) {
		Book book1 = new Book("자바 프로그래밍", 10000);
		book1.print();
		
		Book book2 = new Book(book1);
		book2.title = "자바 디자인패턴";
		book2.print();
		
	}
}
