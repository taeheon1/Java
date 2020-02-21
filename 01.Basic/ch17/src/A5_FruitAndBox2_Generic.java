//A1,2,3,4 는 문제점 이후 개선된 코드
class Apple5 {
   public String toString() {
      return "I am an apple.";
   }
}

class Orange5 {
   public String toString() {
      return "I am an orange.";
   }
}

class Box5<T> { // T : 타입 매개변수(Type Parameter)
            // T에 클래스명이 들어가면 아래에 T들은
           // 전부 해당 클래스명으로 들어감
   private T ob;
   
   public void set(T o) {
      ob = o;
   }
   
   public T get() {
      return ob;
   }
}

public class A5_FruitAndBox2_Generic {

   public static void main(String[] args) {
      Box5<Apple5> aBox = new Box5<Apple5>();
      Box5<Orange5> oBox = new Box5<Orange5>();
      
      // 과일을 박스에 담는다.
      aBox.set(new Apple5()); // 생성자 이외의 것이 들어가면 오류 발생
      oBox.set(new Orange5()); // 제너릭 이전 코드가 갖는 문제점에서
                         // 다른 값이 들어갔을때의 문제점을 해결
      
      System.out.println(aBox.get());
      System.out.println(oBox.get());
      
      
      // T(제네릭)에는 클래스명이 들어갈 수 있기 때문에 String이나 Integer도 가능
      System.out.println();
      Box5<String> sBox = new Box5<String>();
      sBox.set("Hello");
      System.out.println(sBox.get());
      Box5<Integer> iBox = new Box5<Integer>();
      iBox.set(45);
      System.out.println(iBox.get());
   }
}