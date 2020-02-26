interface Viewable2{
	@Deprecated
	public void showIt(String str);
	//문제의 발생 소지가 있거나 개선된 기능의 다른것으로 대체되어서 더이상 필요 없음을 뜻함
	public void brShowIt(String str);
}	//따라서 아직은 호환성 유지를 위해서 존재하지만 이후에 사라질 수있는 클래스 또는
	//메서드를 가리켜 Deprecated 되었다고 한다.	

class Viewer2 implements Viewable2{
	@Override
	public void showIt(String str) {
		System.out.println(str);
	}
	
	@Override
	public void brShowIt(String str) {
		System.out.println('[' + str + ']');
	}
}
public class C2_AtDeprecated {

	public static void main(String[] args) {
		Viewable2 view = new Viewer2();
		view.showIt("Hello Annotations");
		view.brShowIt("Hello Annotations");
	}
}
