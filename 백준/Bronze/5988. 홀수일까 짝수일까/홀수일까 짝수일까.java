import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		BigInteger div = BigInteger.valueOf(2);
		
		for(int i = 0; i < N; i++) {
			BigInteger num = new BigInteger(br.readLine());
			if(num.mod(div).equals(BigInteger.ZERO)) {
				sb.append("even\n");
			} else {
				sb.append("odd\n");
			}
		}	
		System.out.println(sb);
		br.close();
	}	
}