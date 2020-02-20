class Book {
	String name;
	int price;
	
	Book(String aa, int price) {
		name = aa;
		this.price = price;
	}
	
	Book(Book book) {
		name = book.name;
		price = book.price;
	}
	
	public void print() {
		System.out.println(name + ", " + price);
	}
}

public class Ex_Class {
	
	public static void main(String[] args) {
		Book book1 = new Book("홍길동", 100);
		book1.print();
		
		
	}
}