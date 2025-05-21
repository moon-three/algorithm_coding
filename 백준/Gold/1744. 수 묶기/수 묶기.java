import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minusPq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> plusPq = new PriorityQueue<Integer>(Collections.reverseOrder());	// 큰 수끼리 먼저 곱해야하므로 내림차순
		int one = 0;
		int zero = 0;
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input < 0) {
				minusPq.add(input);
			} else if (input > 1) {
				plusPq.add(input);
			} else if (input == 1) {
				one++;
			} else if (input == 0) {
				zero++;
			}
		}
		
		while(true) {
			if(minusPq.size() == 0) {
				break;
			}
			
			if(minusPq.size() == 1) {
				if(zero == 0) {
					sum += minusPq.poll();
				}
				break;
			}
			
			sum += minusPq.poll() * minusPq.poll();
		}
		
		while(true) {
			if(plusPq.size() == 0) {
				break;
			} 
			
			if(plusPq.size() == 1) {
				sum += plusPq.poll();
				break;
			}
			
			sum += plusPq.poll() * plusPq.poll();
		}
		
		sum += one;
		System.out.println(sum);
		br.close();
		
	}
}