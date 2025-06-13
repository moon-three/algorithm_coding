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
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 0; i < arr.length - 2; i++) {
			int cur = arr[i];
			for(int j = i + 1; j < arr.length - 1; j++) {
				cur += arr[j];
				for(int k = j + 1; k < arr.length; k++) {
					cur += arr[k];
					if(cur > max && cur <= M) {
						max = cur;
					}
					cur -= arr[k];			
				}
				cur -= arr[j];
			}
		}
		
		System.out.println(max);
		br.close();		
	}
}