import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];    // 시간 저장
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int n = 0; n <= N; n++) {
            for(int next : Arrays.asList(1, a+1, b+1)) {
                if(n + next > N) continue;
                dp[n + next] = Math.min(dp[n + next], dp[n] + 1);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}