import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N; i++) {
			int data = Integer.parseInt(br.readLine());
			pq.add(data);
		}
		
		int sum = 0;
		
		while(pq.size() > 1) {	// 2개인 경우까지 더하면 끝, 다 끝나면 한개 남음	
			int c1 = pq.poll();
			int c2 = pq.poll();
			sum += c1 + c2;
			pq.add(c1 + c2);
		}			
		
		System.out.println(sum);
		br.close();
		
	}
}