import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		List<Stack<Integer>> stackList = new LinkedList<>();		// 4개의 스택을 담을 배열 선언
		
		for(int i = 0; i < 4; i++) {
			stackList.add(new Stack<Integer>());		// 각각의 스택 초기화
		}
		
		int num = 0;
		
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			
			if(stackList.get(0).isEmpty() || stackList.get(0).peek() < num) stackList.get(0).push(num);
			else if(stackList.get(1).isEmpty() || stackList.get(1).peek() < num) stackList.get(1).push(num);
			else if(stackList.get(2).isEmpty() || stackList.get(2).peek() < num) stackList.get(2).push(num);
			else if(stackList.get(3).isEmpty() || stackList.get(3).peek() < num) stackList.get(3).push(num);
			else {
				System.out.println("NO");
				break;
			}
			
			if(i == N - 1) System.out.println("YES");
		}
		
		br.close();
	}
}