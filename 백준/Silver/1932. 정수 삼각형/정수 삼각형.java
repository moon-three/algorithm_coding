import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        triangle = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= r; c++) {
                triangle[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= r; c++) {
                dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + triangle[r][c];
            }
        }

        int result = 0;
        for(int n = 1; n <= N; n++) {
            result = Math.max(result, dp[N][n]);
        }

        System.out.println(result);
        br.close();
    }
}