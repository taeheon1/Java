//로컬 클래스
interface Printable2 {
	void print();
}
//로컬클래스는 멤버클래스와 유사하다 지역내에서 정의된다는 점에서만 차이를 보임
class Papers2 {
	private String con;

	public Papers2(String s) {
		con = s;
	}

	public Printable2 getPrinter() {
		class Printer2 implements Printable2 { //메서드 안으로 더 깊이 감춤
			public void print() {
				System.out.println(con);
			}
		}
		return new Printer2();
	}

}

public class B3_UseLocalInner {

	public static void main(String[] args) {
		Papers2 p = new Papers2("서류 내용: 행복합니다.");
		Printable2 prn = p.getPrinter();
		prn.print();
	}

}