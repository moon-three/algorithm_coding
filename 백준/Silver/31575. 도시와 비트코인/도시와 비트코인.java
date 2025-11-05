import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int ROAD = 1;
    static final int WALL = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 가로
        int M = Integer.parseInt(st.nextToken());   // 세로

        int[][] table = new int[M+1][N+1];

        // table 초기화
        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            for(int n = 1; n <= N; n++) {
                table[m][n] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[M+1][N+1];
        // 현재 위치의 왼쪽이나 위쪽이 1이면 갈 수 있음
        dp[1][1] = table[1][1];

        // 출발점이 0이면 종료
        if(dp[1][1] == WALL) {
            System.out.println("No");
            return;
        }

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(table[i][j] == WALL) continue;

                if(dp[i-1][j] == 1 || dp[i][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        System.out.println(dp[M][N] == 1 ? "Yes" : "No");
        br.close();
    }
}