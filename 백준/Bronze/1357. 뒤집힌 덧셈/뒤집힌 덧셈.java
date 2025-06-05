import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		
		int A = Integer.parseInt(st.nextToken());
		A = reverse(A);
		int B = Integer.parseInt(st.nextToken());
		B = reverse(B);
		
		result = reverse(A + B);
		System.out.println(result);
		br.close();
	}
	
	public static int reverse(int N) {
		
		char[] chs = String.valueOf(N).toCharArray();
		int left = 0;
		int right = chs.length - 1;
		
		while(left < right) {
			char tmp = chs[left];
			chs[left] = chs[right];
			chs[right] = tmp;
			left++;
			right--;
		}
		
		return Integer.parseInt(new String(chs));
	}
	
}