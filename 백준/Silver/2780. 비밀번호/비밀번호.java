import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] edges = {
                {7}, {2, 4}, {1, 3, 5}, {2, 6}, {1, 5, 7},
                {2, 4, 6, 8}, {3, 5, 9}, {4, 8, 0},
                {5, 7, 9}, {6, 8}
        };

        ArrayList<Integer>[] keypad = new ArrayList[10];

        for(int i = 0; i < keypad.length; i++) {
            keypad[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges[i].length; j++) {
                keypad[i].add(edges[i][j]);
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][10];          // N일때 내 자리에 올 수 있는 경우의 수

            for(int j = 0; j < 10; j++) {
                dp[1][j] = 1;
            }

            for(int len = 2; len <= N; len++) {
                for(int digit = 0; digit < 10; digit++) {
                    for(int prev : keypad[digit]) {
                        dp[len][digit] += dp[len - 1][prev];
                        dp[len][digit] %= 1234567;
                    }
                }
            }

            int sum = 0;
            for(int digit = 0; digit < 10; digit++) {
                sum += dp[N][digit];
                sum %= 1234567;
            }

            System.out.println(sum);
        }
        br.close();
    }
}
