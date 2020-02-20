package Exam;

abstract class Human {
	// 사람답게 만들것임
	int height;
	int age;

	abstract void attackSword();
}

abstract class Elf {
	// 엘프답게 만들것임
	protected int age; // 은닉화
	int height;

	void move() {
		System.out.println("걷기");
	}

	abstract void attackBow();

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}

class HighElf extends Elf {

	void move() {
		System.out.println("소리 안나게 걷기");
	}

	void attackBow() {
		System.out.println("100미터 활 쏘기");

	}

}
interface Dig {
	void myDig();
}

class VeryDig implements Dig {
	public void myDig() {
		System.out.println("땅파기");
	}
}

class DarkElf extends Elf {
	void attackBow() {
		System.out.println("90미터 활 쏘기");
	}

	void move() {
		super.move();
		System.out.println("살금 살금");
	}
}

class NomalElf extends Elf {
	void pringAge() {
		int age = getAge();
		System.out.println(age);
	}

	void attackBow() {
		System.out.println("80미터 활 쏘기");
	}
}

public class Exam03 {

	public static void main(String[] args) {
		HighElf elf1 = new HighElf();
		elf1.attackBow();
		
		NomalElf elf2 = new NomalElf();
		elf2.attackBow();
		
		DarkElf elf3 = new DarkElf();
		elf3.attackBow();

	}
	public static void hi
}
