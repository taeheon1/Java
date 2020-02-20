import java.util.Arrays;

class INum2 {
	private int num;

	public INum2(int num) {
		this.num = num;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this.num == ((INum2) obj).num)
			return true;
		else
			return false;
	}
}

public class F5_ArrayObjEquals2 {

	public static void main(String[] args) {
		INum2[] ar1 = new INum2[3];
		INum2[] ar2 = new INum2[3];

		ar1[0] = new INum2(1);
		ar2[0] = new INum2(1);

		ar1[1] = new INum2(2);
		ar2[1] = new INum2(2);

		ar1[2] = new INum2(3);
		ar2[2] = new INum2(3);

		System.out.println(Arrays.equals(ar1, ar2));
	}

}
//두 배열에 동일한 값으로 초기화된 서로 다른 인스턴스를 각각 저장함.
//그러나, 배열의 비교 결과는 false이다.

//인스턴스의 내용이 아닌 참조 값이 비교된다.
