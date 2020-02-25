package chapter3.ex32;

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
//함수의 오버라이딩 printPet 이 오버라이딩 되면서 부모클래스에 있는 printPet 함수의
//기능을 사용하면서 추가 또는 변경을 하기위하여 만들어짐.
//변수의 이름을 생성하는게 힘들게 때문에 오버라이딩의 장점임.
