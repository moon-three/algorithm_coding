import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}
		
		dfs(graph, visited, V, sb);
		
		visited = new boolean[N + 1];
		bfs(graph, visited, V, sb);
	
		System.out.println(sb);		
		br.close();
	}
	
	public static void dfs(int[][] graph, boolean[] visited, int V, StringBuilder sb) {
		visited[V] = true;
		sb.append(V + " ");
		for(int i = 1; i < visited.length; i++) {
			if(visited[i] == false && graph[V][i] == 1) {
				dfs(graph, visited, i, sb);
			}
		}
		sb.delete(sb.length() - 1, sb.length()).append("\n");
	}
	
	public static void bfs(int[][] graph, boolean[] visited, int V, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited[V] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			for(int i = 1; i < visited.length; i++) {
				if(visited[i] == false && graph[cur][i] == 1) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}		
		sb.delete(sb.length() - 1, sb.length());
	}
}
