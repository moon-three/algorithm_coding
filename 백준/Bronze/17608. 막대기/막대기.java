import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int maxHeight = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		while (!stack.isEmpty()) {
			int cur = stack.pop();

			if(cur > maxHeight) {
				maxHeight = cur;
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}