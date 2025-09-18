import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static int[][] map;
    static boolean[][] visited;
    static int maxHeight = 0;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++) {
                int cur = Integer.parseInt(st.nextToken());
                map[r][c] = cur;
                if(cur > maxHeight) maxHeight = cur;
            }
        }

        int result = 1; // 초기값 : 1 (아무것도 물에 잠기지 않을 경우)

        for(int h = 1; h <= maxHeight; h++) {
            visited = new boolean[N+1][N+1];
            int cnt = 0;

            for(int r = 1; r <= N; r++) {
                for(int c = 1; c <= N; c++) {
                    if(map[r][c] > h && !visited[r][c]) {
                        bfs(r, c, h);
                        cnt++;
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
        br.close();
    }

    static void bfs(int r, int c, int h) {
        queue.add(new int[] {r, c});
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[_n];
            int m = cur[_m];

            for(int[] dir : dirs) {
                int next_n = n + dir[_n];
                int next_m = m + dir[_m];

                if(0 < next_n && next_n <= N &&
                        0 < next_m && next_m <= N &&
                        !visited[next_n][next_m] &&
                        map[next_n][next_m] > h) {
                    visited[next_n][next_m] = true;
                    queue.add(new int[] {next_n, next_m});
                }
            }
        }
    }
}