import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A3_Write7ToFile2 {

   public static void main(String[] args) throws IOException {
      OutputStream out = null;

      try {
			out = new FileOutputStream("data.dat");
         out.write(66);
      } catch (IOException e) {
      } finally {
         if (out != null) {
            try {
               out.close();
            } catch (IOException e) {
            }
         }
      }
   }
}