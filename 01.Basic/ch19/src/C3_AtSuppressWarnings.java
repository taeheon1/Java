interface Viewable3 {
	@Deprecated
	public void showIt(String str);

	public void brShowIt(String str);
}

class Viewer3 implements Viewable3 {

	@Override
	@SuppressWarnings("deprecation") //deprecation 관련 경고 메시지 생략
	public void showIt(String str) {
		System.out.println(str);
	}

	@Override
	public void brShowIt(String str) {
		System.out.println('[' + str + ']');
	}
}

public class C3_AtSuppressWarnings {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Viewable3 view = new Viewer3();
		view.showIt("Hello Annotations");
		view.brShowIt("Hello Annotation");
	}
}
//@Deprecated 선언을 했을 때 도스창에서 컴파일시 아래와 같이 컴파일 경고 
//D:\KimYuBin\workspace\Java\01Basic\CH19\src>javac -encoding UTF8 C2_AtDeprecated.java
//Note: C2_AtDeprecated.java uses or overrides a deprecated API.
//Note: Recompile with -Xlint:deprecation for details.
//--------------------------------------------------
//-Xlint옵션을 추가하여 자세히 봄
//D:\KimYuBin\workspace\Java\01Basic\CH19\src>javac -encoding UTF8 -Xlint C2_AtDeprecated.java
//C2_AtDeprecated.java:14: warning: [deprecation] showIt(String) in Viewable2 has been deprecated
//     public void showIt(String str) {
//                 ^
//C2_AtDeprecated.java:28: warning: [deprecation] showIt(String) in Viewable2 has been deprecated
//             view.showIt("Hello Annotations"); // Deprecated가 되면 메소드에 줄이 그어져있지만 쓰여짐
//                 ^
//2 warnings
