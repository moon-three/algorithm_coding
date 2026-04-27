import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dist = new int[N+1][M+1][2];
        for(int n = 0; n <= N; n++) {
            for(int m =0; m <= M; m++) {
                Arrays.fill(dist[n][m], -1);
            }
        }

        // 탐색
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});
        dist[1][1][0] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];
            int gram = cur[2];

            for(int[] dir : dirs) {
                int next_n = n + dir[0];
                int next_m = m + dir[1];

                // 범위
                if(next_n <= 0 || next_n > N || next_m <= 0 || next_m > M) continue;
                // 검 없을 때 벽인 경우
                if(gram == 0 && map[next_n][next_m] == 1) continue;

                int next_gram = gram;
                if(map[next_n][next_m] == 2) next_gram = 1;

                // 이미 방문했으면 continue
                if(dist[next_n][next_m][next_gram] != -1) continue;

                dist[next_n][next_m][next_gram] = dist[n][m][gram] + 1;
                queue.add(new int[] {next_n, next_m, next_gram});
            }
        }
        
        if(dist[N][M][0] == -1 && dist[N][M][1] == -1) {
            System.out.println("Fail");
            return;
        }
        
        int cnt;
        if(dist[N][M][0] == -1) cnt = dist[N][M][1];
        else if(dist[N][M][1] == -1) cnt = dist[N][M][0];
        else cnt = Math.min(dist[N][M][0], dist[N][M][1]);

        if(cnt > T) System.out.println("Fail");
        else System.out.println(cnt);
    }
}