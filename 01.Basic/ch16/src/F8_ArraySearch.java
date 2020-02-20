import java.util.Arrays;

public class F8_ArraySearch {
   // binarySearch는 이진 탐색을 진행! (반씩 나눠서 탐색하는 것)
   // 그리고 이진 탐색을 위해서는 탐색 이전에
   // 데이터들이 오름차순으로 정렬되어 있어야 한다.

   public static void main(String[] args) {
      int[] ar = {33, 55, 11, 44, 22};
      
      Arrays.sort(ar);
      for(int n : ar) System.out.print(n + "\t");
      System.out.println();
      
      int idx = Arrays.binarySearch(ar, 33);
      System.out.println("Index of 33: " + idx);
   }
}