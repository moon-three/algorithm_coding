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
        int N = Integer.parseInt(st.nextToken());   // 강아지 수
        int M = Integer.parseInt(st.nextToken());   // 닫힌 구간 개수
        int A =  Integer.parseInt(st.nextToken());  // A 마법
        int B =  Integer.parseInt(st.nextToken());  // B 마법

        boolean[] blocked = new boolean[N+1];

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int i = s; i <= e; i++) {
                blocked[i] = true;
            }
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int n = 0; n <= N; n++) {
            if(blocked[n]) continue;
            for(int next : Arrays.asList(A, B)) {
                if(n + next > N) continue;
                dp[n + next] = Math.min(dp[n + next], dp[n] + 1);
            }
        }

        System.out.println(dp[N] == INF ? -1 : dp[N]);
        br.close();
    }
}