import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D3_IOExceptionCase3 {

	public static void main(String[] args) {
		try {
			md1();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void md1() throws IOException { //IOEception 예외 넘긴다고 명시
		md2();
	}

	public static void md2() throws IOException { //IOEception 예외 넘긴다고 명시
		Path file = Paths.get("D:\\Leetaeheon\\Java\\Study\\Simple.txt");
		BufferedWriter writer = null;
		writer = Files.newBufferedWriter(file);
		writer.write('A');
		writer.write('Z');
		
		if(writer != null)
			writer.close();
	}
	
}
