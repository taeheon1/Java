//오버라이딩 = 기능추가 or 기능변경
package ch10;

class Animal {
	String name;
	int age;

	void printPet() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}

class Cat extends Animal {
	String variety;

	void printPet() {
		super.printPet();
		System.out.println("종류 : " + variety);
	}
}

public class Pet {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "양순이";
		cat.age = 5;
		cat.variety = "페르시안";
		cat.printPet();
		
	}
}
