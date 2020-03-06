import java.time.LocalDate;

//LocalDate 는 시각 정보가 생략된 '날짜 정보' 를 표현하기 위한 클래스
public class A2_LocalDateDemo1 {

	public static void main(String[] args) {
		//오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today :" + today);
		
		//올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: "+ xmas);
		
		//올 해의 크리스마스 이브
		LocalDate eve = xmas.minusDays(1);
		System.out.println("Xmas Eve: "+eve);

	}

}
