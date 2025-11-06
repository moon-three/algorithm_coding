import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for(int i = 1; i <= N; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;

            int maxJump = A[i];

            for(int j = 1; j <= maxJump; j++) {
                if(i + j > N) continue;

                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? "-1"  : dp[N]);
        br.close();
    }
}
