import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Puzzle {
	String[][] pz = new String[3][3];

	Puzzle() {
		pzSetNMix(); // 생성과 동시에 초기화
	}

	private void pzSetNMix() { // 퍼즐을 생성하고 섞음
		// 랜덤값이 중복되지 않게 list에 넣기
		Random rnd = new Random();
		List<String> list = new ArrayList<>();
		while (true) {
			if (list.size() == 9) {
				list.set(list.indexOf("9"), "x"); // 9를 찾아서 x로 바꿈
				break;
			}
			// 중복처리
			String rndnum = String.valueOf(rnd.nextInt(9) + 1); // 1~9까지 랜덤숫자를 String형태로 바꿈
			if (!list.contains(rndnum)) { // list안에 이미 같은 숫자가 있으면 넣지 않음.
				list.add(rndnum);
			}
		}

		// 2차원 배열에 넣기
		int k = 0; // k는 list의 index넘버
		for (int i = 0; i < pz.length; i++) {
			for (int j = 0; j < pz[i].length; j++) {
				pz[i][j] = list.get(k);
				k++;
			}
		}
	}

	public void pzPrint(int err) { // 퍼즐 출력
		// 에러 표출
		String errstr = "";
		if (err == 1) {
			errstr = "잘못 입력하셨습니다.";
		} else if (err == 2) {
			errstr = "이동할 수 없는 위치입니다. 다시 입력해주세요.";
		}
		System.out.println("\n\n\n\n" + errstr + "\n");

		// 퍼즐 출력
		for (int i = 0; i < pz.length; i++) {
			for (int j = 0; j < pz[i].length; j++) {
				System.out.print(pz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int succ() { // 성공 여부 보기
		int k = 1; // 1부터8까지 같나
		int count = 0;
		for (int i = 0; i < pz.length; i++) {
			for (int j = 0; j < pz[i].length; j++) {
				if (pz[i][j].equals(String.valueOf(k))) {
					count++;
				}
				k++;
			}
		}
		if (count == 8) // 만약 8이면 성공
			return 1;
		else // 아니면 아직 계속하기
			return 0;
	}

	public int[] xLoca() { // x의 위치 찾기
		int xLocai = -1;
		int xLocaj = -1;
		for (int i = 0; i < pz.length; i++) {
			for (int j = 0; j < pz[i].length; j++) {
				if (pz[i][j].equals("x")) {
					xLocai = i;
					xLocaj = j;
				}
				if ((xLocai >= 0) && (xLocaj) >= 0) // x를 찾으면 for문 나가기 더이상 돌 필요없음
					break;
			}
			if ((xLocai >= 0) && (xLocaj) >= 0) // x를 찾으면 for문 나가기 더이상 돌 필요없음
				break;
		}
		int[] xLocaij = { xLocai, xLocaj }; // return int를 여러개 해주려고 배열로 리턴

		return xLocaij;
	}

	public void moveLR(int move) { // x위치 좌우 이동
		int[] xLocaij = xLoca(); // xLocaxy[0] = x값의 i위치, xLocaxy[1] = x값의 j위치
		String temp = pz[xLocaij[0]][xLocaij[1]];
		pz[xLocaij[0]][xLocaij[1]] = pz[xLocaij[0]][xLocaij[1] + move];
		pz[xLocaij[0]][xLocaij[1] + move] = temp;
	}

	public void moveUD(int move) { // x위치 위아래 이동
		int[] xLocaxy = xLoca(); // xLocaxy[0] = x값의 i위치, xLocaxy[1] = x값의 j위치
		String temp = pz[xLocaxy[0]][xLocaxy[1]];
		pz[xLocaxy[0]][xLocaxy[1]] = pz[xLocaxy[0] + move][xLocaxy[1]];
		pz[xLocaxy[0] + move][xLocaxy[1]] = temp;
	}
}

public class Game3By3Puzzle {

	static int err = 0;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Puzzle pz = new Puzzle();

		while (true) {
			pz.pzPrint(err);
			err = 0;
			System.out.println("[ Move ] a:Left d:Right w:Up s:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.print("이동키를 입력하세요 : ");
			String instr = sc.next();
			try {
				move(instr, pz);
			} catch (ArrayIndexOutOfBoundsException e) {
				err = 2;
			}
			if (instr.equalsIgnoreCase("k"))
				break;
			if (pz.succ() == 1) {
				pz.pzPrint(err);
				System.out.print("정답입니다. ");
				break;
			}
		}
		System.out.println("게임을 종료합니다.\nGood Bye~");
	}

	public static void move(String instr, Puzzle pz) {
		if (instr.equalsIgnoreCase("w")) {
			pz.moveUD(-1);
		} else if (instr.equalsIgnoreCase("a")) {
			pz.moveLR(-1);
		} else if (instr.equalsIgnoreCase("s")) {
			pz.moveUD(1);
		} else if (instr.equalsIgnoreCase("d")) {
			pz.moveLR(1);
		} else {
			err = 1;
		}
	}
}