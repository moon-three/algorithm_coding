import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long result = n;		// 모든 수를 서로소라고 가정
		
		for(long i = 2; i * i <= n; i++) {		
			if(n % i == 0) {					// 2부터 해당 수로 나눠지면 서로소가 아니기 때문에
				result = result - result / i;	// 해당 배수만큼의 개수를 빼준다
				while (n % i == 0) {			// 효율을 위해 (작업한 소인수 제거)
					n /= i;
				}
			}			
		}
		if(n > 1) {			// 마지막에 소인수가 하나 남으면 처리
			result = result - result / n;
		}
		
		System.out.println(result);
		
		br.close();
	}
}