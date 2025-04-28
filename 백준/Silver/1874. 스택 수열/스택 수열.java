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
			
			while (num <= cur) {    // stack 에 비교값과 같을때까지 넣기
				stack.add(num++);
				sb.append("+").append("\n");
			}
			
			if(cur == stack.pop()) {    // 같을때까지 넣었으니 꺼냈을때는 비교값과 같다
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
