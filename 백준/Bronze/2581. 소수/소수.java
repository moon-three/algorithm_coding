import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		// 소수 == 나랑 1 말고는 나눠지지 않는다, 2개의 약수를 가진다

		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = M; i <= N; i++) {
			
			if(N < 2) {
				break;
			}
			if(i < 2) {
				continue;
			}

			boolean isPrime = true;
			
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				} 
			}
			
			if(isPrime) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		if(sum < 2) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);						
		}

		br.close();
	}
}