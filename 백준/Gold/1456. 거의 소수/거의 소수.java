import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 최대 입력값이 10^14
		// 문제에서 거의 소수 : 소수의 거듭제곱
		// 10^14 의 제곱근인 10^7 까지 구하면 된다
		int[] arr = new int[(int)Math.sqrt(B) + 1];
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}
		
		// 에스토스테네스의 체
		for(int i = 2; i <= Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) {
				continue;
			}
			
			for(int j = i * i; j < arr.length; j = j + i) {
				arr[j] = 0;
			}
		}
		
		int cnt = 0;
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] != 0) {
				// 소수를 제외한, 소수를 거듭제곱한 수만 구하는 것.. 
				long cur = (long)arr[i] * arr[i];
				
				while(cur <= B) {
					if(cur >= A) {
						cnt++;
					}
					// 오버플로우 방지 
					// cur * arr[i] 가 B보다 작아야함 -> 양변 나눠서 확인
					if(cur > B / arr[i]) {
						break;
					}
					cur *= arr[i];
				}
				
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}