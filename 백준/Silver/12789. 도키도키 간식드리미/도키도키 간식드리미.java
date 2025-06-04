import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
				
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		int order = 1;
		int idx = 0;
		
		while(idx < arr.length) {
			if(arr[idx] == order) {
				idx++;
				order++;
			} else if(!stack.isEmpty() && stack.peek() == order) {
				stack.pop();
				order++;
			}
			else {
				stack.push(arr[idx++]);
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == order) {
				stack.pop();
				order++;
			} else {
				break;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
		
		br.close();
	}
}