import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// 최소공배수 : 두 수의 곱 / 최대 공약수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int result = a * b / gcd(a, b);
			System.out.println(result);
			
		}	
		br.close();

	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {		// 나머지가 0이면 a 는 최대공약수라는 뜻
			return a;
		} else {
			return gcd(b, a % b);		
		}
	}
	
}
