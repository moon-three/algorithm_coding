import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        dp[1][1] = 0;

        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                int jump = table[n][m];

                for(int next = 1; next <= jump; next++) {
                    if(n + next > N) break;

                    dp[n + next][m] = Math.min(dp[n + next][m], dp[n][m] + 1);
                }

                for(int next = 1; next <= jump; next++) {
                    if(m + next > M) break;
                    dp[n][m + next] = Math.min(dp[n][m + next], dp[n][m] + 1);
                }
            }
        }
        System.out.println(dp[N][M]);
        br.close();
    }
}