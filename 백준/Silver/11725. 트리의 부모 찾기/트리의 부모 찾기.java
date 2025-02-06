import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] parent = new int[N + 1];		// 부모 저장 배열
		ArrayList<Integer>[] edge = new ArrayList[N + 1];	// 간선을 저장할 배열

		for(int i = 1; i < edge.length; i++) {		// 배열 초기화
			edge[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			edge[node1].add(node2);		// 무방향 간선 저장
			edge[node2].add(node1);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);	// 1번 root 노드부터 시작
		parent[1] = 0;
		
		while(!queue.isEmpty()) {
			int curId = queue.poll();
			
			for(int next : edge[curId]) {	// 연결된 노드들:next 
				if(parent[next] == 0) {		// 아직 부모 노드가 없다면 (방문하지 않았다면)
					parent[next] = curId;	// 해당 노드(next)의 부모(parent[next]에 현재노드(curId) 저장
					queue.add(next);
				}
			}
		}
		
		for(int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
		
		br.close();
	}
}