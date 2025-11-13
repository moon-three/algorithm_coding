import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int BUILDING = 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();

        ArrayList<Integer>[] campus = new ArrayList[BUILDING];
        for(int i = 0; i < campus.length; i++) {
            campus[i] = new ArrayList<>();
        }

        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {2, 4},
                {3, 4}, {3, 5}, {4, 5}, {4, 6}, {5, 7}, {6, 7}
        };

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            campus[u].add(v);
            campus[v].add(u);
        }
        
        long[][] dp = new long[D+1][BUILDING];  // 해당 시간에 해당 건물에 오는 경우의 수를 저장

        dp[0][0] = 1;       // 시작 : 0번째에 0번 건물에 도착하는 경우의 수는 1개

        for(int d = 1; d <= D; d++) {
            for(int b = 0; b < BUILDING; b++) {
                for(int next : campus[b]) {
                    dp[d][b] += dp[d-1][next];
                    dp[d][b] %= 1000000007;
                }
            }
        }

        System.out.println(dp[D][0]);
        sc.close();
    }
}
