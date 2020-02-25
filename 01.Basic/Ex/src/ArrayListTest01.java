import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("몇개의 숫자를 입력 하시겠습니까 ?");
		int num = sc.nextInt();

		int[] arr = new int[num];
		System.out.println(num + " 개의숫자를 입력하세요");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if ((0 > arr[i]) || (arr[i] > 9)) {
				System.out.println("잘못입력하였습니다. 숫자는 0~9까지입니다.");
				i--;
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (!list.contains(arr[i]))
				list.add(arr[i]);
		}

		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}
}

// 사용자에게 몇개의 숫자를 입력받을지 개수를 입력받고
// 그만큼 배열선언후에 그 개수만큼 0~9까지의 숫자만 입력받아
// 입력받은 순서대로 출력되야돼
// 그리고 그 배열에서 연속적으로 나타나는 숫자를 하나만 남기고 다 삭제
// ex) [1 1 2 1 4 3 0 3 4] 면은 [1 2 4 3 0] 이렇게 되게 출력
