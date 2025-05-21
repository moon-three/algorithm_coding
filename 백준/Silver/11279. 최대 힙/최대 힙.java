import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			int data = Integer.parseInt(br.readLine());
			pq.add(data);
			if(data == 0) {
				sb.append(pq.poll()).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}