package chapter3.ex31;

class Book {
	String title;
	String genre;

	void print() {
		System.out.println("제목 : " + title);
		System.out.println("장르 : " + genre);
	}
}

class Novel extends Book {
	String writer;

	void print() {
		super.print();
		System.out.println("저자 : " + writer);
	}
}

class Magazine extends Book {
	int day;

	void print() {
		super.print();
		System.out.println("발매일 : " + day + "일");
	}
}

public class Bookshelf {

	public static void main(String[] args) {
		Novel nov = new Novel();
		nov.title = "구운몽";
		nov.genre = "고전문학";
		nov.writer = "김만중";
		nov.print();
		System.out.println();
		
		Magazine mag = new Magazine();
		mag.title = "월간 자바 그림책";
		mag.genre = "컴퓨터";
		mag.day = 20;
		mag.print();

	}

}
