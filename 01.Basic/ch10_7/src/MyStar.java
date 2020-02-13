abstract class Unit {
	int 체력;

	abstract void doMove();
}

class 마린 extends Unit {

	마린() {

	}

	마린(int type) {
		if (type == 1) {
			System.out.println("한복 입은 마린 생성");
		} else if (type == 2) {
			System.out.println("산타클로스 복장의 마린 생성");

		}
	}

	// 오버라이딩 - 기능 추가
	void doMove() {
		System.out.println("속도 100으로 걸어서 이동");
		System.out.println("공격");
	}

	void doAttack() {
		System.out.println("총쏘기");
	}
}

class 메딕 extends Unit {
	// 오버라이딩 - 기능 바꿈
	void doMove() {
		System.out.println("속도 90으로 걸어서 이동");
		System.out.println("회복");
	}

	void doHeal() {
		System.out.println("회복시키기");
	}
}

class 건물1단계 {
	// 골격 구조만 정의
	int 체력;

}

abstract class 건물2단계 extends 건물1단계 {
	// 외형을 정의
	// 종족별로 1단계를 생산하도록 정의만 함
	void 생산1단계();
}

interface 날기 {
	void 날기(); // abstrackt 생략 인터페이스는 모든게 추상적이다.
}

class 테란_배럭 extends 건물2단계 {
	void 생산1단계() {
		System.out.println("마린 생산");
	}
}

class 테란_배럭2 extends 테란_배럭 implements 날기 {
	public void 날기() {
		System.out.println("인간적으로 천천히 날기");
	}
}

class 프로토스_게이트웨이 extends 건물2단계 {
	void 생산1단계() {
		System.out.println("질럿 생산");
	}
}

class 저그_해처리 extends 건물2단계 {
	void 생산1단계() {
		System.out.println("저글링 생산");
	}
}

public class MyStar {

	public static void main(String[] args) {
		Unit unit1 = new 마린();
		Unit unitMe1 = new 메딕();
		Unit unitMe2 = new 메딕();
		Unit unitMe3 = new 메딕();
		Unit unitMe4 = new 메딕();

		건물2단계 build1 = new 테란_배럭2();
		build1.생산1단계();

	}

}
