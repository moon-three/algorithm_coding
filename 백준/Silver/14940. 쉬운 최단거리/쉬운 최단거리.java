import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int UND = -1;
    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    static int N, M;

    static int[][] graph;
    static boolean[][] visited;

    static int[][] dist;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        dist = new int[N+1][M+1];

        int[] point = new int[2];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                int data = Integer.parseInt(st.nextToken());
                if(data == 2) {
                   point[0] = n;
                   point[1] = m;
                }
                graph[n][m] = data;
                dist[n][m] = UND;
            }
        }

        bfs(point[0], point[1]);

        StringBuilder sb = new StringBuilder();
        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                if(graph[n][m] == 0) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dist[n][m]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void bfs(int a, int b) {
        queue.add(new int[] {a, b});
        visited[a][b] = true;
        dist[a][b] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];

            for(int[] dir : dirs) {
                int next_n = n + dir[_n];
                int next_m = m + dir[_m];

                if(0 < next_n && next_n <= N &&
                    0 < next_m && next_m <= M &&
                    !visited[next_n][next_m] &&
                    graph[next_n][next_m] == 1) {
                    dist[next_n][next_m] = dist[n][m] + 1;
                    visited[next_n][next_m] = true;
                    queue.add(new int[] {next_n, next_m});
                }
            }
        }
    }
}