import java.util.Arrays;
//두 배열의 내용 비교
public class F3_ArrayEquals {

	public static void main(String[] args) {
		int[] ar1 = {1,2,3,4,5};
		int[] ar2 = Arrays.copyOf(ar1, ar1.length);
		
		System.out.println(Arrays.equals(ar1, ar2));

	}

}
//두 배열에 저장된 데이터의 수, 순서 그리고 내용이 같을 때 true를 반환한다.
//(배열의 길이가 다를 경우에는 false를 반환한다.)