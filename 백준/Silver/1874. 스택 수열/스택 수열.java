import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean flag = true;
		
		for(int i = 0; i < N; i++) {
			int cur = arr[i];
			
			while (num <= cur) {
				stack.add(num++);
				sb.append("+").append("\n");
			}
			
			if(cur == stack.pop()) {
				sb.append("-").append("\n");				
			} else {
				flag = false;
				break;
			}			
		}
		
		if(flag) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
		br.close();
	}
}
