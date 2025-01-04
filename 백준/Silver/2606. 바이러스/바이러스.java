import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 총 컴퓨터 수
		int M = Integer.parseInt(br.readLine());	// 연결된 컴퓨터 쌍의 수
		
		HashMap<Integer, Set<Integer>> hm = new HashMap<>();	// key에 컴퓨터번호, value(set)에 연결된 컴퓨터들을 담는다
		
		for(int i = 1; i <= N; i++) {	
			hm.put(i, new HashSet<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
				int com1 = Integer.parseInt(st.nextToken());
				int com2 = Integer.parseInt(st.nextToken());
			
				hm.get(com1).add(com2);
				hm.get(com2).add(com1);
		}
		
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		
		Set<Integer> virus = new HashSet<Integer>();
		virus.add(1);	// 바이러스 걸린 컴퓨터(1)은 무조건 넣어준 뒤 출력 시 1을 빼준다
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			visited[1] = true;		// 1은 방문한 것으로 처리, 다시 큐에 들어가지 않는다
			
			for(int key : hm.get(i)) {
//				System.out.println("key : " + key);
//				System.out.println(visited[key]);
				if (!visited[key]) queue.add(key);
				visited[key] = true;	// 큐에 담은 애들은 다시 큐에 담지않기 위해 방문한 것으로 표시
				virus.add(key);
			}
//			System.out.println("set : " + virus);
//			System.out.println();
		}
		
		System.out.println(virus.size() - 1);
		
	}
}