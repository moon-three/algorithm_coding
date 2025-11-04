import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A, K;
    static int[] dp;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[1000001];

        queue.add(A);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : Arrays.asList(cur + 1, cur * 2)) {
                if(next <= 1000000 && dp[next] == 0) {
                    dp[next] = dp[cur] + 1;
                    queue.add(next);
                }
            }

            if(dp[K] != 0) {
                break;
            }
        }
        System.out.println(dp[K]);
        br.close();
    }
}
