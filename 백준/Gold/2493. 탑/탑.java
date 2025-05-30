import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**	반례
 	6
	9 4 6 3 7 8
	A : 0 1 1 3 1 1
 */

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<>();		// 배열의 [0]에는 탑번호, [1]에는 높이를 저장

		int N = Integer.parseInt(br.readLine());
	
		/**
		 1) 스택에 데이터를 담는다
		 2) 스택에 값이 있다면 자기보다 작은 값은 제거 (그러면 자기보다 큰 값이 남겠지?)
		 3) 스택이 비어있으면 (자기보다 큰 값이 없다는 뜻) 0, 아니면 stack.peek()
		 */
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int data = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek()[1] < data) {
				stack.pop();
			}
			
			if(!stack.isEmpty()) {
				sb.append(stack.peek()[0] + " ");
			} else {
				sb.append(0 + " ");
			}
			
			stack.push(new int[]{i, data});
		}
		
		System.out.println(new String(sb).trim());
		br.close();
	}
}