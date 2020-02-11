class Calc{
	int add(int a,int b)
	{
		return a+b;
	}
}
public class Calculation {
	
	// main() 메서드와 같은 오브젝트 내의 메서드에서는 static 을 붙인다.
	static void disp() {
		int nRtn;
		Calc calc = new Calc();
		nRtn = calc.add(3, 9);
		
		System.out.println("3+9= " + nRtn);
	}
	public static void main(String[] args) {
		
		disp();
		

	}

}
