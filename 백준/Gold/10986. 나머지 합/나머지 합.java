import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		long[] remains = new long[M];
		long sum = 0;
		long answer = 0;
		
		// 누적합 구하기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sum += Long.parseLong(st.nextToken());
			arr[i] = sum; 
		}
		
		// M으로 나눈 나머지 저장 
		for(int i = 0; i < N; i++) {
			int remainer = (int)(arr[i] % M);
			remains[remainer]++;		// 나머지가 같은 게 몇 개인지 카운트
			if(remainer == 0) {			// 나눠떨어지면 카운트
				answer++;
			}
		}
		
		// 조합 구하기
		for(int i = 0; i < M; i++) {
			answer += (remains[i] * (remains[i] - 1)) / 2;
		}
		
		System.out.println(answer);
		br.close();
		
	}
}