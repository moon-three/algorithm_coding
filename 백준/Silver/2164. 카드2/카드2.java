import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while(deque.size() > 1) {
			
			deque.pollFirst();
			
			deque.addLast(deque.pollFirst());
			
		}
		System.out.println(deque.poll());
		sc.close();
	}
}