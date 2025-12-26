import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 5;
    static final int WALL = -1;
    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int[][] table;
    static boolean[][] visited;
    static int appleCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        table = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        visited[r][c] = true;
        boolean result = dfs(new int[]{r, c}, 0);
        System.out.println(result? 1 : 0);
        br.close();
    }

    public static boolean dfs(int[] point, int depth) {
        if (depth == 3) {
            return appleCnt >= 2;
        }

        for (int[] dir : dirs) {
            int next_n = point[_n] + dir[_n];
            int next_m = point[_m] + dir[_m];

            if (next_n < 0 || next_m < 0 || next_n >= N || next_m >= N) continue;

            if (table[next_n][next_m] != WALL && !visited[next_n][next_m]) {
                if (table[next_n][next_m] == 1) appleCnt++;
                visited[next_n][next_m] = true;
                boolean isPossible = dfs(new int[]{next_n, next_m}, depth + 1);
                if (isPossible) return true;
                if (table[next_n][next_m] == 1) appleCnt--;
                visited[next_n][next_m] = false;
            }
        }
        return false;
    }
}
