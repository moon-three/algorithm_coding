import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];    // 사용할 수 있는 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());    // 카드 최대 사용 횟수

        int maxNum = nums[nums.length - 1] * K;     // 만들 수 있는 최대 수
        int[] dp = new int[maxNum + 1];         // 사용한 카드 개수
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for(int i = 0; i <= maxNum; i++) {
            if(dp[i] != INF && dp[i] < K) {
                for(int num : nums) {
                    int next = i + num;
                    if(next > maxNum) continue;
                    dp[next] = Math.min(dp[next], dp[i] + 1);
                }
            }
        }

        for(int i = 1; i <= maxNum; i++) {
            if(dp[i] == INF) {
                String answer = i % 2 == 0 ? "holsoon" : "jjaksoon";
                System.out.println(answer + " win at " + i);
                return;
            }
        }

        // 만약 모든 숫자가 다 만들어진다면
        System.out.println(maxNum % 2 != 0 ?
                "holsoon win at " + maxNum : "jjaksoon win at " + maxNum);
        br.close();
        
    }
}