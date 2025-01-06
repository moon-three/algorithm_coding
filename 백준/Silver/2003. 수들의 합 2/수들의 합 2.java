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
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];	// 주어진 배열 값
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;
		
		while(true) {

			if(sum > M) {
				sum -= arr[left];
				left++;
			} else if (right == arr.length) {
				break;
			} else {
				sum += arr[right];
				right++;
			}
			
			if(sum == M) count++;
		
		}
		System.out.println(count);
		
		br.close();
	}
}