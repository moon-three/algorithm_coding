import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] table;
    static boolean[] isTeam;
    static int minDiffer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        table = new int[N + 1][N + 1];
        isTeam = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isTeam[1] = true;   // 스타트:123 링크:456 / 스타트:456 링크:123 방지 (중복방지)
        dfs(0, 1);
        System.out.println(minDiffer);
        br.close();
    }

    static void dfs(int cnt, int start) {
        if (cnt == N / 2 - 1) {
            // 그 팀의 점수를 구하고 비교
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (isTeam[i] && isTeam[j]) {
                        startTeam += table[i][j] + table[j][i];
                    } else if (!isTeam[i] && !isTeam[j]) {
                        linkTeam += table[i][j] + table[j][i];
                    }
                }
            }
            minDiffer = Math.min(minDiffer, Math.abs(startTeam - linkTeam));
            return;
        }

        // 팀을 나누고
        for (int i = start; i <= N; i++) {
            if (!isTeam[i]) {
                isTeam[i] = true;
                dfs(cnt + 1, i + 1);
                isTeam[i] = false;
            }
        }
    }
}