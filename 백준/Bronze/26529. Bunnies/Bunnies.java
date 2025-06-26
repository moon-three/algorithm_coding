import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[46];
		
		arr[0] = 1;
		arr[1] = 1;

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int data = Integer.parseInt(br.readLine());
			int result = fibonacci(data);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		br.close();	
	}
	
	public static int fibonacci(int n) {
		
		for(int i = 2; i <= n; i++) {
			if(arr[i] != 0) {
				continue;
			}
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		return arr[n];
	}
	
}