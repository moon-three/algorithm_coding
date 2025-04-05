import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == -1) {
				break;
			}
			
			String result = n + " = 1";
			int sum = 1;
			
			for(int i = 2; i < n; i++) {
				if(n % i == 0) {
					sum += i;
					result += " + " + i;
				}
			}
			
			if(n == sum) {
				System.out.println(result);
			} else {
				System.out.println(n + " is NOT perfect.");
			}
	
		}
	
		br.close();
		
	}
}
