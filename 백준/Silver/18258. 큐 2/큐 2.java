import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				queue.add(X);
				break;
			case "pop":
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
				break;
			}
			
			
		}		
		String result = new String(sb);
		System.out.println(result.trim());
		br.close();
	}
}