import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// 에라토스테네스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];	// N까지 배열생성
		
		for(int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(arr[i] == 0) {
				continue;
			}
			
			for(int j = i * i; j <= N; j += i) {
				arr[j] = 0;
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}
		
		br.close();
	}
}
