import java.time.ZoneId;

//시간대를 표현하는 ZoneId 클래스
public class B1_ZoneIdDemo1 {

	public static void main(String[] args) {
		ZoneId paris = ZoneId.of("Europe/Paris");
		System.out.println(paris);
	}

}
