import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 배열의 개수
		int M = Integer.parseInt(st.nextToken());	// 구해야하는 횟수
		
		st = new StringTokenizer(br.readLine());
		int[] sum = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sum[end] - sum[start - 1]);
		}
		
		br.close();
	}
}