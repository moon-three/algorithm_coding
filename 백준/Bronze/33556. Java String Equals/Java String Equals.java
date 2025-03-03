import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		if(A.equals("null")) {
			System.out.println("NullPointerException");
			System.out.println("NullPointerException");
		} else if (B.equals("null")) {
			System.out.println(false);
			System.out.println(false);
		} else {			
			System.out.println(A.equals(B));
			System.out.println(A.equalsIgnoreCase(B));
		}
		
		br.close();
	}
}
