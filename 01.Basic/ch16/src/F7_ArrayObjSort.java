import java.util.Arrays;

class Person1 implements Comparable {
	private String name;
	private int age;

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public int compareTo(Object o) {
		Person1 p = (Person1) o;

		int nNum = this.name.compareTo(p.name);
		return nNum;

//		if(this.age > p.age)
//			return 1;
//		else if(this.age < p.age)
//			return -1;
//		else
//			return 0;
	}

	@Override
	public String toString() {
		return name + ": " + age;
	}
}

public class F7_ArrayObjSort {

	public static void main(String[] args) {
		Person1[] ar = new Person1[3];

		ar[0] = new Person1("홍길동", 29);
		ar[1] = new Person1("전우치", 15);
		ar[2] = new Person1("손오공", 37);

		Arrays.sort(ar);

		for (Person1 p : ar)
			System.out.println(p);

	}

}
//Comparable 인터페이스를 구현한다는 것은 
//오름차순 순서상 크고 작음에 대한 기준을 제공한다는 의미
