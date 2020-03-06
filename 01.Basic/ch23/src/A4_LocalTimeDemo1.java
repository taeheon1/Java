import java.time.LocalTime;

//LocalDate는 날짜 정보를 표현하기 위한 클래스, 반면 LocalTime은 시각 정보를 표현하기 위한
public class A4_LocalTimeDemo1 {

	public static void main(String[] args) {
		// 현재 시각
		LocalTime now = LocalTime.now();
		System.out.println("지금 시각 : " + now);

		// 2시간 10분 뒤 화상 미팅 예정
		LocalTime mt = now.plusHours(2);
		mt = mt.plusMinutes(10);

		// 화상 미팅 시각
		System.out.println("화상 미팅 시각: " + mt);

	}

}
//LocalTime의 메소드
//public LocalTime plusHours(long hoursToAdd)
//public LocalTime plusMinutes(long minutesToAdd)
//public LocalTime plusSeconds(long secondsToAdd)