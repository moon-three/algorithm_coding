import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> deque = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			int now = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().value >= now) {
				deque.pollLast();
			}
			deque.addLast(new Node(now, i));
			
			while(i - deque.getFirst().index + 1 > L) {
				deque.pollFirst();
			}
			sb.append(deque.getFirst().value + " ");
		}
		
		System.out.println(new String(sb).trim());
		br.close();
		
	}
}

class Node {
	int value;
	int index;
	
	public Node(int value, int index) {
		this.value = value;
		this.index = index;
	}
}