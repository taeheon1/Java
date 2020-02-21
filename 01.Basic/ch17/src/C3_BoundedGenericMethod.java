class BoxE<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		return ob;
	}

//   private Integer ob;
//   
//   public void set(Integer o) {
//      ob = o;
//   }
//   
//   public Integer get() {
//      return ob;
//   }
}

class BoxFactoryE {
	// 클래스 전체가 아닌 메서드 하나에 대해 제네릭으로 정의
	public static <T extends Number> BoxE<T> makeBox(T o) {
		BoxE<T> box = new BoxE<T>();
		box.set(o);

		System.out.println("Boxed data: " + o.intValue());
		return box;
	}

// 위 코드의 제네릭에 Integer가 들어가게 되고 아래 주석의 코드처럼 변함.
//   public static Integer BoxE<Integer> makeBox(Integer o) {
//      BoxE<Integer> box = new BoxE<Integer>();
//      box.set(o);
//      
//      System.out.println("Boxed data: " + o.intValue());
//      return box;
//   }
//  ------>
//   public static Integer BoxE makeBox(Integer o) {
//   BoxE box = new BoxE();
//   box.set(o);
//   
//   System.out.println("Boxed data: " + o.intValue());
//   return box;
//   }
}

class UnboxerE {
	public static <T extends Number> T openBox(BoxE<T> box) {
		System.out.println("Unboxed data: " + box.get().intValue());
		return box.get();
	}

//   public static Integer openBox2(BoxE<Integer> box) {
//      System.out.println("Unboxed data: " + box.get().intValue());
//      return box.get();
//   }
//   ------>
//   public static Integer openBox2(BoxE box) {
//   System.out.println("Unboxed data: " + box.get().intValue());
//   return box.get();
//   }
}

class C3_BoundedGenericMethod {

	public static void main(String[] args) {
		BoxE<Integer> sBox = BoxFactoryE.makeBox(new Integer(5959));

		int n = UnboxerE.openBox(sBox);
		System.out.println("Returned data: " + n);
	}
}