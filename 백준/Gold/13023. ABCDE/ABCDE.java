import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static final int END = 5;
	static boolean arrive;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N];
		visited = new boolean[N];
		// 배열 초기화
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			DFS(i, 1);		// 시작점, 깊이
		}
		
		if(arrive) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		br.close();
	}
	
	public static void DFS(int i, int depth) {
		if(depth == END) {
			arrive = true;
			return;
		}
		visited[i] = true;
		for(int n : arr[i]) {
			if(!visited[n]) {
				DFS(n, depth + 1);				
			}
		}
		visited[i] = false;
	}

}