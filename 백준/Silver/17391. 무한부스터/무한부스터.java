import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                table[n][m] = Integer.parseInt(st.nextToken());
                dp[n][m] = INF;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        dp[1][1] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];

            int jump = table[n][m];
            for(int i = 1; i <= jump; i++) {
                int next_n = n + i;
                if(next_n > N) break;

                if(dp[next_n][m] > dp[n][m] + 1) {
                    dp[next_n][m] = dp[n][m] + 1;
                    queue.add(new int[]{next_n, m});
                }
            }

            for(int i = 1; i <= jump; i++) {
                int next_m = m + i;
                if(next_m > M) break;

                if(dp[n][next_m] > dp[n][m] + 1) {
                    dp[n][next_m] = dp[n][m] + 1;
                    queue.add(new int[]{n, next_m});
                }
            }
        }
        System.out.println(dp[N][M]);
        br.close();
    }
}
