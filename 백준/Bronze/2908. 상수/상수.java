import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int reA = reverse(A);
		int reB = reverse(B);
		
		System.out.println(reA > reB ? reA : reB);
		br.close();
	}
	
	public static int reverse(String S) {
		
		char[] chs = S.toCharArray();
		
		char tmp = chs[0];
		chs[0] = chs[2];
		chs[2] = tmp;
		
		return Integer.parseInt(new String(chs));
	}
}