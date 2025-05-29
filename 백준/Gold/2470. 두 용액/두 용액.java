import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		findNearZero(arr);
		
		System.out.println(result[0] + " " + result[1]);
		br.close();
	}
	
	public static void findNearZero(int[] arr) {
		
		int left = 0;
		int right = arr.length - 1;
		int sum = Integer.MAX_VALUE;
			
		while (left < right) {
		
			int cur = arr[left] + arr[right];
			
			if(cur == 0) {
				result[0] = arr[left];
				result[1] = arr[right];
				return;
			}
			
			int diff = 0 - cur;
			if(diff < 0) {
				diff *= -1;
			}
	
			if(diff < sum) {
				result[0] = arr[left];
				result[1] = arr[right];
				sum = diff;
			}
			
			if(cur < 0) {
				left++;
			} else {
				right--;				
			}
			
		}
	}
	
}