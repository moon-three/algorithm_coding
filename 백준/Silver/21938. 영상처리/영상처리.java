import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static final int[][] dirs = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    static int[][] table;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int sum = (R + G + B) / 3;
                table[n][m] = sum;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if(table[n][m] >= T) table[n][m] = 255;
                else table[n][m] = 0;
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(table[i][j] == 255) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    public static void bfs(int i, int j) {
        queue.add(new int[]{i, j});
        table[i][j] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];

            for(int[] dir : dirs) {
                int next_n = n + dir[0];
                int next_m = m + dir[1];

                if(next_n < 0 || next_m < 0 || next_n >= N || next_m >= M) continue;

                if(table[next_n][next_m] == 255) {
                    table[next_n][next_m] = 0;
                    queue.add(new int[]{next_n, next_m});
                }
            }
        }

    }
}
