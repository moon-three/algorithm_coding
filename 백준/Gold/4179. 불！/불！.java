import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[][] DIRS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] miro = new int[R][C];
        int[][] dist = new int[R][C];
        for(int[] arr : dist) {
            Arrays.fill(arr, -1);
        }
        int[] jihun = new int[2];
        for(int r = 0; r < R; r++) {
            String line = br.readLine();
            for(int c = 0; c < C; c++) {
                char ch = line.charAt(c);
                miro[r][c] = ch;
                if(ch == 'J') {
                    jihun[0] = r;
                    jihun[1] = c;
                } else if(ch == 'F') queue.offer(new int[]{r,c});
            }
        }
        queue.offer(jihun);
        dist[jihun[0]][jihun[1]] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = cur[0];
            int m = cur[1];

            if(miro[n][m] == 'F') { // 불이면
                for (int[] dir : DIRS) {
                    int next_n = n + dir[0];
                    int next_m = m + dir[1];

                    if (next_n < 0 || next_n >= R || next_m < 0 || next_m >= C)
                        continue;
                    if (miro[next_n][next_m] != '.') continue;
                    miro[next_n][next_m] = 'F'; // 불남
                    queue.offer(new int[] {next_n, next_m});
                }
            }
            if(miro[n][m] == 'J') { // 지훈이면
                for (int[] dir : DIRS) {
                    int next_n = n + dir[0];
                    int next_m = m + dir[1];

                    if(next_n < 0 || next_n >= R || next_m < 0 || next_m >= C) {
                        System.out.println(dist[n][m] + 1);
                        return;
                    }
                    if(miro[next_n][next_m] == '#' || miro[next_n][next_m] == 'F') continue;
                    if(dist[next_n][next_m] != -1) continue;
                    miro[next_n][next_m] = 'J';
                    dist[next_n][next_m] = dist[n][m] + 1;
                    queue.offer(new int[]{next_n, next_m});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}