package chapter2.ex21;

class Wdata {
	int month;
	int day;
	String sky;
}

public class Weather {

	public static void main(String[] args) {
		Wdata today = new Wdata();
		today.month = 10;
		today.day = 5;
		today.sky = "맑음";

		System.out.println(today.month + "월" + today.day + "일" + today.sky);
	}

}
//오브젝트를 생성하기 위해서는 new 연산자가 사용된다.