import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static int[][] A;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 행
		int M = Integer.parseInt(st.nextToken());	// 열
		
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] sArr = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(sArr[j]);
			}
		}
		
		BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
		br.close();
				
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});	// 위치를 큐에 저장
		visited[i][j] =  true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int k = 0; k < 4; k++) {
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				if(x >= 0 && y >= 0 && x < A.length && y < A[0].length) {
					if(A[x][y] != 0 && !visited[x][y]) {
						A[x][y] = A[cur[0]][cur[1]] + 1;
						queue.add(new int[] {x, y});
						visited[x][y] = true;
					}
				}
			}
		}
		
	}
	
}