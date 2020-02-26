//어노테이션 
interface Viewable1 {
	public void showIt(String str);
}

class Viewer1 implements Viewable1 {
	@Override   // 오버라이딩을 올바르게 했는지 컴파일러가 체크
				// 오버라이딩을 할 때 메서드 이름 실수 방지
	public void showIt(String str) {
		System.out.println(str);
	}
}

public class C1_AtOverride {

	public static void main(String[] args) {
		Viewable1 view = new Viewer1();
		view.showIt("Hello Annotations");
	}
}
