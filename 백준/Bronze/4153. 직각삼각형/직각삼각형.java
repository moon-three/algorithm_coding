import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[3];

		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
			}
			
			Arrays.sort(arr);
			
			if(arr[0] + arr[1] + arr[2] == 0) {
				break;
			}
			
			if(arr[0] + arr[1] == arr[2]) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}	
		
		System.out.println(sb);
		br.close();	
	}
}