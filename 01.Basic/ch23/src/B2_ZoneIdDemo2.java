import java.time.ZoneId;

public class B2_ZoneIdDemo2 {

	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds()
		.stream()
		//filter(s -> s.startsWith("Assia")) //Assia로 시작하는것만 호출
		.sorted()
		.forEach(s -> System.out.println(s));
	}
}
