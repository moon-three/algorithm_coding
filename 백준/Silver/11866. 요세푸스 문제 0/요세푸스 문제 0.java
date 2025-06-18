import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String data = sc.nextLine();
		
		int N = Integer.parseInt(data.split(" ")[0]);
		int K = Integer.parseInt(data.split(" ")[1]);
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			cnt++;
			
			if(cnt != K) {
				queue.add(now);
			} else {
				list.add(now);
				cnt = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size() - 1) {
				sb.append(list.get(i));
			} else {
				sb.append(list.get(i) + ", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
		sc.close();
		
	}
}
