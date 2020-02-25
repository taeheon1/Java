package chapter3.ex37;

interface Cry {

	void cry();
}

class Cat implements Cry {
	public void cry() {
		System.out.println("야옹~");
	}
}

class Dog {
	public void cry() {
		System.out.println("멍멍!");
	}
}

public class CheckCry {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();

		if (cat instanceof Cry) {
			cat.cry();
		}
		if (dog instanceof Cry) {
			dog.cry();
		}

	}

}
