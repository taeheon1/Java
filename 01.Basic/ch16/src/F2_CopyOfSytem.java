import java.util.Arrays;

public class F2_CopyOfSytem {

	public static void main(String[] args) {
		double[] org = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		double[] cpy = new double[3];

		// 미리 만들어져 있는 배열에 복사한다.
		System.arraycopy(org, 1, cpy, 0, 3);

		for (double d : cpy)
			System.out.print(d + "\t");
		
		System.out.println();

	}

}
//앞의 예제와 달리 배열을 새로 생성 하지 않고 존재하는 배열에 복사를
//하려는 경우에는 이와 같이 메서드를 호출하면 된다.