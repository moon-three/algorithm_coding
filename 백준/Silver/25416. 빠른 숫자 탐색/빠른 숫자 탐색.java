import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int WALL = -1;
    static int[][] table = new int[5][5];
    static int[][] dist = new int[5][5];
    static final int _n = 0;
    static final int _m = 1;
    static final int[][] dirs = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            st =  new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = bfs(r, c);
        System.out.println(result);
        br.close();
    }

    static int bfs(int r, int c) {
        queue.add(new int[]{r,c});
        dist[r][c] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[_n];
            int m = cur[_m];

            if(table[n][m] == 1) return dist[n][m];

            for(int[] dir : dirs) {
                int next_n = n + dir[_n];
                int next_m = m + dir[_m];

                if(next_n < 0 || next_m < 0 || next_n >= 5 || next_m >= 5) continue;
                if(table[next_n][next_m] == WALL) continue;

                if(dist[next_n][next_m] == -1) {
                    dist[next_n][next_m] = dist[n][m] + 1;
                    queue.add(new int[]{next_n, next_m});
                }
            }
        }
        return -1;
    }
}