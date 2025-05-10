import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 노드 수
		int M = Integer.parseInt(st.nextToken());	// 간선 수
		
		// 노드 수만큼 방문배열, 노드 수만큼 인접리스트
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] nodes = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		
		// 인접리스트 초기화
		for(int i = 0; i < N + 1; i++) {
			nodes[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			nodes[A].add(B);
			nodes[B].add(A);
			// 양방향이므로 양쪽에 다 넣어주기
		}
		
		int cnt = 0;
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) {
				cnt++;
				DFS(nodes, visited, i);
			}
		}
		System.out.println(cnt);
		br.close();
	}
	
	public static void DFS(ArrayList<Integer>[] nodes, boolean[] visited, int i) {
		if(visited[i]) {
			return;
		}
		visited[i] = true;
		for(int node : nodes[i]) {
			if(!visited[node]) {
				DFS(nodes, visited, node);				
			}
		}
	}	
}