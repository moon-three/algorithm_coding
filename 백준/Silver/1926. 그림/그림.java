import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int COLORED = 1;

    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= M; c++) {
                if(map[r][c] == COLORED && !visited[r][c]) {
                    cnt++;
                    int area = getArea(r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);
        br.close();
    }

    static int getArea(int r, int c) {
        int area = 0;

        queue.add(new int[] {r, c});
        visited[r][c] = true;
        area++;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[_n];
            int m = cur[_m];

            for(int[] dir : dirs) {
                int next_n = n + dir[_n];
                int next_m = m + dir[_m];

                if(0 < next_n && next_n <= N &&
                    0 < next_m && next_m <= M &&
                    !visited[next_n][next_m] &&
                    map[next_n][next_m] == COLORED) {
                    queue.add(new int[] {next_n, next_m});
                    visited[next_n][next_m] = true;
                    area++;
                }
            }
        }
        return area;
    }
}