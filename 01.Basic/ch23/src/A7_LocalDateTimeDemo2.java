import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class A7_LocalDateTimeDemo2 {

	public static void main(String[] args) {
		// 현재 시각
		LocalDateTime today = LocalDateTime.of(2020, 4, 25, 11, 20);

		// 항공편1의 출발 시간
		LocalDateTime flight1 = LocalDateTime.of(2020, 5, 14, 11, 25);

		// 항공편2의 출발 시간
		LocalDateTime flight2 = LocalDateTime.of(2020, 5, 13, 15, 30);

		// 빠른 항공편을 선택하는 과정
		LocalDateTime myFlight;

		if (flight1.isBefore(flight2))
			myFlight = flight1;
		else
			myFlight = flight2;

		// 빠른 항공편의 비행 탑승까지 남은 날짜 계산
		Period day = Period.between(today.toLocalDate(), myFlight.toLocalDate());

		// 빠른 항공편의 비행 탑승까지 남은 시간 계산
		Duration time = Duration.between(today.toLocalTime(), myFlight.toLocalTime());

		// 비행 탑승까지 남은 날짜와 시간 출력
		System.out.println(day);
		System.out.println(time);
	}
}