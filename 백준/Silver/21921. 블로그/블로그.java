import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] sum = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(sum));
		
		int left = 0;
		int right = X;
		int maxVisit = 0;
		int count = 0;
		
		while(true) {
			if(sum[right] - sum[left] > maxVisit) {
				maxVisit = sum[right] - sum[left];
				count = 0;
			}
			if(sum[right] - sum[left] == maxVisit) {
				count++;
			}
			right++;
			left++;
			if(right == sum.length) break;
			
		}
		
		if(maxVisit != 0) {
			System.out.println(maxVisit);
			System.out.println(count);			
		} else {
			System.out.println("SAD");
		}
		
		br.close();
	}
}