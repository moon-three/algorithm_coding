import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		// 바구니 초기화
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		int cnt = 0;
		
		while(cnt < M) {
			st = new StringTokenizer(br.readLine());
			int idx1 = Integer.parseInt(st.nextToken()) - 1;
			int idx2 = Integer.parseInt(st.nextToken()) - 1;
			
			if(idx1 == idx2) {
				cnt++;
				continue;
			}
			
			int tmp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = tmp;
			
			cnt++;
		}
		
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		
		System.out.println(new String(sb).trim());
		br.close();
	}
}
