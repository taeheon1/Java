
public class ArraysTest1 {

	public static void main(String[] args) {
		int arr[] = new int[10];
		int sum = 0;
		double avg;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			
		}
		for (int j = 0; j < arr.length; j++) {
			sum += arr[j];
		}
		System.out.println("덧셈: " + sum);
		
		avg = (double)sum/arr.length;
		System.out.println("평균 : " + avg);
	}

}
//1차원 배열 1부터 10까지 반복문이용 배열 초기화, 전체 합 , 평균