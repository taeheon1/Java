import java.util.Scanner;

public class ArrayTest2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int max;
		do {
			System.out.println("숫자의 개수를 입력해주세요. (1 ~ 100)");
			max = input.nextInt();
		} while (max > 100 || max < 1);
		int[] arr = new int[max];

		int num;
		System.out.println("배열을 입력해주세요. (0 ~ 9)");
		for (int i = 0; i < arr.length; i++) {
			do {
				num = input.nextInt();
				if (num > 9 || num < 0) {
					System.out.println("배열을 입력해주세요. (0 ~ 9)");
				} else {
					arr[i] = num;
				}
			} while (num > 9 || num < 0);
		}

		// 체크를 위해 만든 index와 안에 값이 같은 배열을 생성과 초기화
		int[] ar = new int[10];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i;
		}

		int arcount = 0; // result 배열의 길이를 설정하기 위해 count를 샘
		// ar[i]와 arr[j]를 비교해 값이 같으면 카운트를 올려주고 ar[i]를 10을 바꿔줘 if 조건이 더이상 안맞게 만듬
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (ar[i] == arr[j]) {
					ar[i] = 10;
					arcount++;
				}
			}
		}

		int[] result = new int[arcount]; // count를 사용해 배열의 길이를 만듬

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				if (ar[j] == 10) {
					result[i] = j;
					ar[j] = j;
					break;
				}
			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}

// 사용자에게 몇개의 숫자를 입력받을지 개수를 입력받고
// 그만큼 배열선언후에 그 개수만큼 0~9까지의 숫자만 입력받아
// 그리고 그 배열에서 연속적으로 나타나는 숫자를 하나만 남기고 다 삭제
// ex) [1 1 2 1 4 3 0 3 4] 면은 [0 1 2 3 4] 이렇게 되게 출력