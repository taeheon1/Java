package ch10_7;

public class Polymorphism2_3 {

	public static void main(String[] args) {
		String doc = "프린터로 출력을 합니다.";

		Printable prn1 = new PrnDrvSamsung();
		prn1.print(doc);

		ColorPrintable prn2 = new PrnColorDrvSamsung();
		prn2.print(doc);
		prn2.printCMYK(doc);

//		 자식을 부모에게 넣을 수는 있으나, 같은 레벨의 클래스에 넣을 수는 없다.
//		 PrnColorDrvSamsug prn3 = new PrnColorDrvEpson();
	
		
	}

}
