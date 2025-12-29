import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int SHARK = 1;
    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
            {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };  // 8방향
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N][M];
        // 초기화
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                int input = Integer.parseInt(st.nextToken());
                if(input != SHARK) dist[n][m] = -1; // 상어 아닌 곳은 -1
                else queue.add(new int[]{n, m});
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];

            for(int[] dir : dirs) {
                int next_n = n + dir[_n];
                int next_m = m + dir[_m];

                if(next_n < 0 || next_m < 0 || next_n >= N || next_m >= M) continue;

                if(dist[next_n][next_m] == -1) {
                    dist[next_n][next_m] = dist[n][m] + 1;
                    queue.add(new int[]{next_n, next_m});
                }
            }
        }

        int max = 0;
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                max = Math.max(max, dist[n][m]);
            }
        }

        System.out.println(max);
        br.close();
    }
}