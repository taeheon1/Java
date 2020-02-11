
public class x1 {

	public static void main(String[] args) {
		//1 씩 증가
		for(int i=0; i<100; i=i+1) {
			//System.out.println(i);
		}
		//2 씩 증가
		for(int i=0; i<100; i=i+2) {
			//System.out.println(i);
			
		}
		//조건에 따라 증가
		int n = 0;
		
		for(int i=0; i<100;) {
			if(n>10) {
				i=i+3;
				}else {
					i=i+1;
				}
			System.out.println(i);
		}
		//1씩감소
		for(int i=9; i>=0; i--) {
			
		}
		//2씩감소
		for (int i=9; i>=0; i=i-2) {
			
		}
	}
}

