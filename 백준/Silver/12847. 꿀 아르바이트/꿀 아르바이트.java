import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 총 일수
		int M = Integer.parseInt(st.nextToken());	// 내가 일할 수 있는 날
		
		// 0 10 30 60 80 90
		long[] sum = new long[N + 1];
				
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		long maxValue = 0;
		
		while(true) {
			long value = sum[left + M] - sum[left];
			if(value > maxValue) maxValue = value;
		
			left++;
			
			if((left + M) == sum.length) break;		
		}
		
		System.out.println(maxValue);
		
		br.close();
	}
}