/*오버로딩 : 오버로딩이란 하나의 클래스 내에 인수의 개수나 형이
다른 동일한 이름의 메서드를 여러 개 정의하는 것이다. */
class Calc
{
	int add(int a, int b)
	{
		return a+b;
	}
	int add(int a)
	{
		return a+1;
	}
	double add(double a, double b)
	{
		return a+b;
	}
}

public class Calculation {

	public static void main(String[] args) {
		Calc calc = new Calc();
		int nRtn1 = calc.add(3,9);
		int nRtn2 = calc.add(3);
		double nRtn3 = calc.add(3.0, 9.0);
		
		System.out.println("Rtn1 = " + nRtn1);
		System.out.println("Rtn2 = " + nRtn2);
		System.out.println("Rtn3 = " + nRtn3);

	}
}
